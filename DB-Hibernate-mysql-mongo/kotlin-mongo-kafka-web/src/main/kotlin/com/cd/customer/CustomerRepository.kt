package com.cd.customer

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CustomerRepository : ReactiveMongoRepository<Customer, String> {

    /**
     * Method to get the list of active customers based on patron id, address type and sort order.
     * This is a spring-data style method name to query the database, mongo-db - in this case
     */
//    fun findAllByDeletedAndCustomerTypeInAndCustomerIdLikeIgnoreCaseOrDeletedAndCustomerTypeInAndAddressTypeKeyLikeIgnoreCase(
//        deletedForCustomerId: Boolean,
//        customerTypeForCustomerId: Array<String>,
//        customerId: String,
//        deletedForAddressTypeKey: Boolean,
//        customerTypeForAddressTypeKey: Array<String>,
//        addressTypeKey: String,
//        sort: Sort
//    ): Flux<Customer>
}