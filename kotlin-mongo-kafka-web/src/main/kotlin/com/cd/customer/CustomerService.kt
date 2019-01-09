package com.cd.customer

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    @Throws(CustomerNotFoundException::class)
    fun getById(id: String): Mono<Customer> {
        return customerRepository.findById(id)
            .switchIfEmpty(Mono.error(CustomerNotFoundException("Could not find customer with id: $id")))
    }

    fun getAll(): Flux<Customer> {
        return customerRepository.findAll()
    }

    @Throws(InvalidCustomerException::class)
    fun create(commodity: Mono<Customer>): Mono<Customer> {
        return commodity
            .switchIfEmpty(Mono.error(InvalidCustomerException()))
            .flatMap { it.validate() }
            .flatMap {
                customerRepository.save(
                    it.copy(
                        id = UUID.randomUUID().toString()
                    )
                )
            }
    }

    /**
     * Method to update customer
     */
    @Throws(InvalidCustomerException::class)
    fun update(customer: Mono<Customer>): Mono<Customer> {
        return customer
            .switchIfEmpty(Mono.error(InvalidCustomerException()))

            .flatMap {
                customerRepository.save(it)
            }
    }

//    /**
//     * Query customers by customerId, addressTypeKey, and deleted status.
//     * Optional: A sort criteria can be specified.
//     */
//    fun getAllByCustomerIdOrAddressType(
//        deleted: Boolean,
//        customerId: String,
//        addressTypeKey: String,
//        customerType: Array<String>,
//        sort: Sort
//    ): Flux<Customer> {
//        return customerRepository.findAllByDeletedAndCustomerTypeInAndCustomerIdLikeIgnoreCaseOrDeletedAndCustomerTypeInAndAddressTypeKeyLikeIgnoreCase(
//            deletedForCustomerId = deleted,
//            deletedForAddressTypeKey = deleted,
//            customerId = customerId,
//            addressTypeKey = addressTypeKey,
//            customerTypeForCustomerId = customerType,
//            customerTypeForAddressTypeKey = customerType,
//            sort = sort
//        )
//    }

    fun Customer.validate(): Mono<Customer> {
        // validation logic here
        return reactor.core.publisher.Mono.just(this)
    }
}