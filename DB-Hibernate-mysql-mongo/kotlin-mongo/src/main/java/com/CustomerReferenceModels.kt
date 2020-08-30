package com

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

/**
 * Internal representation of a customer's industry reference data.
 */
@Document
data class CustomerIndustryReference(
        /**
         * A Customer Industry Reference File is uniquely identified by a 'CIF ID' and a 'Sublocation Suffix' ('CIF Code')
         */
        @Id
        val id: String,
        val name: String,
        val createddate: Date =   Date()

//        val lastName: String,
//        val firstName: String,
//        val mailingAddress: Address,
//        val physicalAddress: Address,
//        val phoneNumber: String,
 )

/**
 * This maps to the raw IRF CIF files that we receive. This is converted to a `CustomerIndustryReference`.
 */
@Suppress("MemberVisibilityCanBePrivate")
data class RawCustomerIRF(
        val dunsNumberCifId: String,
        val cifCode: String,
        val recordExpirationDate: String,
        val organizationName1: String,
        val organizationName2: String,
        val organizationName3: String,
        val stateProvinceAbbreviation: String,
        val sourceSystemDataSource: String,
        val postalCode: String,
        val sourceType: String,
        val sourceUpdateDate: String,
        val mailingAddress1: String,
        val mailingAddress2: String,
        val mailingAddress3: String,
        val countryName: String,
        /** This is the id of the root customer that this is nested under. */
        val organizationToOrganizationRole: String,
        val physicalAddress1: String,
        val physicalAddress2: String,
        val physicalAddress3: String,
        val updateReason: String,
        /** This is the "tax_id_qualifier" */
        val nationalId: String,
        val physicalCityName: String,
        val mailingCityName: String,
        val countryCode: String,
        val hqIndicator: String,
        val phoneNumber: String,
        /** This is the id of the parent customer that this is nested under. */
        val organizationRole: String,

        @JsonIgnore
        override val unknownFields: MutableMap<String, Any> = mutableMapOf()
) : SupportsUnknownFieldsTransparently {

    override fun setUnknownField(name: String, value: Any) {
        super.setUnknownField(name, value)
        println("Encountered unknown field when parsing customer IRF data (cif). fieldName=$name;fieldValue=$value")
    }

//    fun toCustomerIndustryReference(): CustomerIndustryReference {
//        val customer = CustomerIndustryReference(
//                id = dunsNumberCifId.trim().padStart(9, '0') + cifCode.trim().padStart(4, '0'),
//                name = organizationName1.trim(),
//                mailingAddress = Address(
//                        streetAddressLine1 = mailingAddress1.trim(),
//                        city = mailingCityName.trim(),
//                        state = stateProvinceAbbreviation.trim(),
//                        zipCode = postalCode.trim(),
//                        country = countryCode.trim()
//                ),
//                physicalAddress = Address(
//                        streetAddressLine1 = physicalAddress1.trim(),
//                        city = physicalCityName.trim(),
//                        state = stateProvinceAbbreviation.trim(),
//                        zipCode = postalCode.trim(),
//                        country = countryCode.trim()
//                ),
//                phoneNumber = phoneNumber.trim()
//        )
//        customer.additionalFields["recordExpirationDate"] = recordExpirationDate
//        customer.additionalFields["sourceSystemDataSource"] = sourceSystemDataSource
//        customer.additionalFields["cifCode"] = cifCode
//        customer.additionalFields["sourceType"] = sourceType
//        customer.additionalFields["sourceUpdateDate"] = sourceUpdateDate
//        customer.additionalFields["countryName"] = countryName
//        customer.additionalFields["organizationToOrganizationRole"] = organizationToOrganizationRole
//        customer.additionalFields["updateReason"] = updateReason
//        customer.additionalFields["nationalId"] = nationalId
//        customer.additionalFields["dunsNumberCifId"] = dunsNumberCifId
//        customer.additionalFields["hqIndicator"] = hqIndicator
//        customer.additionalFields["organizationRole"] = organizationRole
//        customer.additionalFields["organizationName2"] = organizationName2
//        customer.additionalFields["organizationName3"] = organizationName3
//        customer.additionalFields["physicalAddress2"] = physicalAddress2
//        customer.additionalFields["physicalAddress3"] = physicalAddress3
//        customer.additionalFields["mailingAddress2"] = mailingAddress2
//        customer.additionalFields["mailingAddress3"] = mailingAddress3
//        customer.additionalFields.putAll(unknownFields)
//        return customer
//    }
}

