package com.cd.customer

//import com.cd.common.model.Address
//import com.cd.common.model.Audit
//import com.cd.common.model.Phone
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Customer(
    @Id
    val id: String?, // Reference: ID BIGINT PRIMARY KEY NOT NULL,
    val customerId: String="ccc", // Reference: PD_ID VARCHAR(9) NULL,
    val railroadId: String, // Reference: PD_ADDRESS_TYPE_KEY VARCHAR(3) NULL,
//    val customerType: String, // Reference: PD_PATRON_TYPE VARCHAR(1) NULL,
//    val name: String, // Reference: PD_NAME VARCHAR(35) NOT NULL,
//    val abbrevName: String? = null, // Reference: PD_ABREV_NAME VARCHAR(12) NULL,
////    val address: Address? = Address(), // Reference: PD_ADDRESS_*
//    val attention: String? = null, // Reference: PD_ATTN VARCHAR(30) NULL,
//
////    val phone: Phone? = Phone(), // Reference: PD_PHONE_*
////    val fax: Phone? = Phone(),  // Reference: PD_FAX_*
//
//    val cifNumber: Int? = null, // Reference: PD_CIF_NUMBER INT NULL,
//    val defaultTrackId: String? = null, // Reference: PD_DEFAULT_TRACK_ID VARCHAR(10) NULL,
//    val milepost: String? = null, // Reference: PD_MILEPOST VARCHAR(7) NULL,
//    val parentCustomerId: String? = null, // Reference: PARENT_PD_ID VARCHAR(9) NULL,
//    val parentCustomerAddressType: String? = null, // Reference: PARENT_PD_ADDRESS_TYPE VARCHAR(3) NULL,
//    val lastUsedDate: ZonedDateTime? = null, // Reference: PD_LAST_USED_DATE TIMESTAMP NULL,
//    val alternateCode: String? = null, // Reference: PD_ALTERNATE_CODE VARCHAR(15) NULL,
//    val onlineStationId: String? = null, // Reference: STATION_ID VARCHAR(7) NULL,
//    val servingStationId: String? = null, // Reference: SERVING_STATION_ID VARCHAR(7) NULL,
//    val defaultStationId: String? = null, // Reference: DEFAULT_STATION_ID VARCHAR(7) NULL,
//    val zoneId: String? = null, // Reference: ZONE_ID VARCHAR(6) NULL,
   val deleted: Boolean  // Reference: DELETED BOOLEAN NOT NULL DEFAULT FALSE

//    val audit: Audit? = Audit()
)

class CustomerNotFoundException(message: String = "Customer not found") : Exception(message)
class InvalidCustomerException(message: String = "Invalid Customer") : Exception(message)
