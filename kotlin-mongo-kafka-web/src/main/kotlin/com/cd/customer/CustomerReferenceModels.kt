package com.cd.customer

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

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
//        val mailingAddress: Address,
//        val physicalAddress: Address,
        val phoneNumber: String

)




