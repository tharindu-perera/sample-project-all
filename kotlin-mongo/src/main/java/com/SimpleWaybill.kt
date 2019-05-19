package com


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

enum class WaybillStatus {
    Inbound,
    Active,
    Completed,
    Rejected,
    Inactive
}

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class SimpleWaybill(
    @JsonProperty("id")
    @Id
    val id: String?,
    @JsonProperty("railroadId")
    val railroadId: String = "",
    @JsonProperty("commodity")
    val commodity: Commodity = Commodity(),
    @JsonProperty("customers")
    val customers: Customers = Customers(),
    @JsonProperty("equipmentDetails")
    val equipmentDetails: EquipmentDetails = EquipmentDetails(),
    @JsonProperty("errors")
    val errors: WaybillErrors = WaybillErrors(),
    @JsonProperty("referenceInformation")
    var referenceInformation: ReferenceInformation = ReferenceInformation(),
    @JsonProperty("route")
    val route: List<RouteSegment> = listOf(),
    @JsonProperty("stations")
    val stations: Stations = Stations(),
    @JsonProperty("moveInstructions")
    val moveInstructions: AdditionalMoveInstructions = AdditionalMoveInstructions(),
    @JsonProperty("versionHistory")
    val versionHistory: VersionHistory = VersionHistory(),

    //TODO get this from token
    @JsonProperty("createdBy")
    val createdBy: String = "System",
//    @JsonProperty("createdDate")

    val createdDate: LocalDateTime = LocalDateTime.now(),
    @JsonProperty("isLatest")
    private val isLatest: Boolean = true,
    @JsonProperty("updatedBy")
    val updatedBy: String = "System",
    @JsonProperty("updateReason")
    val updateReason: String = ""
) {

    companion object {
        private val DEFAULT_INT = 0
        private val DEFAULT_STRING = ""
        private val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        private val timeFormat: DateFormat = SimpleDateFormat("hh:mm:ss")
    }

    /**
     * We must avoiding naming the below function with the prefix "get" or "set" as those will be auto-mapped to MongoDB
     * by making the val private we ensure that it is never returned to the user unless explicitly requested by calling the function below
     */




}

data class Commodity(
    val agent: String = "",
    @JsonProperty("commodityDescription")
    val commodityDescription: CommodityDescription = CommodityDescription(),
    @JsonProperty("capacityLoadCode")
    val capacityLoadCode: String = "",
    @JsonProperty("hazardLadingQuantity")
    val hazardLadingQuantity: Int? = null,
    @JsonProperty("isHazmat")
    @get:JsonProperty("isHazmat")
    val isHazmat: Boolean = false,
    @JsonProperty("methodOfPayment")
    val methodOfPayment: String = "",
    @JsonProperty("unit")
    val unit: String? = "",
    @JsonProperty("productGroup")
    val productGroup: String? = "",
    @JsonProperty("weightType")
    val weightType: String? = ""
)

data class CommodityDescription(
    val ladingLineItemNumber: Int? = null,
    val ladingDescription: String = "",
    val commodityCode: Int? = null,
    val commodityCodeQualifier: String? = "",
    val commodityCodeDescription: String = ""
)

data class Customer(
    val role: String = "",
    val companyName: String = "",
    val address: Address? = null,
    val id: String = ""
)

data class Customers(
    val consignee: Customer = Customer(),
    val shipper: Customer = Customer(),
    val thirdParties: List<Customer> = listOf(),
    val storage: Customer? = null,
    val industry: Customer? = null
)

data class EquipmentDetails(
    val equipmentId: String = "",
    val aarType: String = "",
    val kind: String = "",
    val dunnage: Int? = null,
    val ediType: String = "",
    val height: Int? = null,
    val length: Int? = null,
    val loadStatus: String? = null,
    val sectionSevenCode: String = "",
    val tareWeight: Int? = null,
    val transportationMethodCode: String = "",
    val weightAllowance: Int? = null,
    val weightQualifierCode: String = "",
    val width: Int? = null,
    val reclaimCode: String = "",
    val haulage: String = "",
    val carHireFlag: Boolean = false,
    val grossWeight: Int? = null,
    val netWeight: Int? = null
)

data class Station(
    val address: Address? = null,
    val freightStationAccountingCode: Int? = null,
    val splc: Int? = null,
    val station: String = ""
)

data class ReferenceInformation(
    val waybillNumber: String = 234.toString(),
    @JsonDeserialize(using = LocalDateDeserializer::class)
    @JsonSerialize(using = LocalDateSerializer::class)
    val waybillDate: LocalDate = LocalDate.now(),
    val waybillStatus: WaybillStatus? = null,
    val senderId: String = "",
    var receiverId: String = "",
    val templateId: String = "",
    val billOfLading: String? = null,
    val blockTo: String = "",
    val switchTo: String = "",
    val referenceInformation: List<CarReferenceInformation> = listOf()

)

data class CarReferenceInformation(
    val referenceCode: String = "",
    val referenceInformation: String = "",
    val referenceDateTime: LocalDateTime = LocalDateTime.now()
)

data class RouteSegment(
    val junctionName: String = "",
    val railRoadName: String = "",
    val role: String? = ""
)

data class Stations(
    @JsonProperty("originStation")
    val originStation: Station = Station(),
    @JsonProperty("destinationStation")
    val destinationStation: Station = Station()
)

data class AdditionalMoveInstructions(
    val switchInstructions: String = "",
    val specialInstructions: String = "",
    val remarks: String = "",
    val trafficType: String = "FFFF",
    val ediTo: String = ""
)

data class VersionHistory(
    val changelog: Map<String, ChangeObject> = mapOf(),
    val fieldHistory: MutableMap<String, FieldHistory> = mutableMapOf()
)

data class FieldHistory(
    val history: MutableMap<String, ChangeDetails> = mutableMapOf()
)

data class ChangeObject(
    val changeDetails: MutableList<ChangeDetails> = mutableListOf(),
    val changeEventType: String = "UserInitiatedUpdate",
    val changedBy: String = "User"
)

data class ChangeDetails(
    val previousValue: String? = "",
    val currentValue: String? = "",
    val rawJsonPath: String? = "",
    val simpleJsonPath: String? = "",
    val eventType: String? = ""
)

data class WaybillErrors(
    val count: Int = 0,
    val errorList: List<WaybillErrorObject> = listOf()
)

data class WaybillErrorObject(
    val path: String? = "",
    val error: String? = ""
)



data class BlockToUpdate(
    val waybillNumbers:List<String>,
    val blockTo:String
)
class WaybillNotFoundException(message: String = "Waybill not Found") : Exception(message)
class TooManyWaybillsFoundException(message: String = "Too Many Waybills Found") : Exception(message)
class InvalidWaybillException(message: String = "Invalid Waybill") : Exception(message)
class WaybillNumbersAreRequired(message: String = "Waybill Numbers are required") : java.lang.Exception(message)



