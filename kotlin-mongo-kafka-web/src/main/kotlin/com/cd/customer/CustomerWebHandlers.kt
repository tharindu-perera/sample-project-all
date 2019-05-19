package com.cd.customer

import com.cd.customer.CustomerRoutes.Companion.CUSTOMER_ID
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Component
class CustomerWebHandlers(val customerService: CustomerService) {


    enum class CustomerTypes(var type: String) {
        BILLING("billing"),
        TRANSPORTATION("transportation"),
        INACTIVE("inactive")
    }

    fun getAll(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(customerService.getAll())
    }

    fun getById(serverRequest: ServerRequest): Mono<ServerResponse> {
        val id = serverRequest.pathVariable(CUSTOMER_ID)
        return customerService
            .getById(id)
            .flatMap { ServerResponse.ok().body(BodyInserters.fromObject(it)) }

    }

    fun create(serverRequest: ServerRequest): Mono<ServerResponse> {
        val customerMono = serverRequest.bodyToMono<Customer>()

        return customerService
            .create(customerMono)
            .flatMap { ServerResponse.ok().body(BodyInserters.fromObject(it)) }

    }

    /**
     * Method to update a customer.
     */
    fun update(serverRequest: ServerRequest): Mono<ServerResponse> {
        val customerMono = serverRequest.bodyToMono<Customer>()
        return customerService
            .update(customerMono)
            .flatMap { ServerResponse.ok().body(BodyInserters.fromObject(it)) }

    }

//    /**
//     * Query customers by customerId, addressTypeKey, and deleted status.
//     * Optional: A sort criteria can be specified.
//     */
//     fun getAllByCustomerIdOrAddressType(serverRequest: ServerRequest): Mono<ServerResponse> {
//
//        val searchText = serverRequest.queryParam(SEARCH_VAL)
//        val sortBy = serverRequest.queryParam(SORT_BY)
//        val sortOrder = serverRequest.queryParam(SORT_ORDER)
//        val deleted = serverRequest.queryParam(DELETED)
//        val active = serverRequest.queryParam(ACTIVE)
//
//        // adding default sort field and sort order
//        val searchTextField = if (!searchText.isPresent) "" else searchText.get()
//        val sortByField = if (!sortBy.isPresent || sortBy.get().isEmpty()) "customerId" else sortBy.get()
//        val sortOrderField =
//            if (!sortOrder.isPresent || sortOrder.get().isEmpty()) Sort.Direction.ASC else Sort.Direction.fromString(
//                sortOrder.get()
//            )
//        val deletedField = if (!deleted.isPresent || deleted.get().isEmpty()) "false" else deleted.get()
//        // if active field is not present, consider all customer type
//        var customerTypeField: Array<String> = arrayOf(
//            CustomerTypes.BILLING.type,
//            CustomerTypes.TRANSPORTATION.type,
//            CustomerTypes.INACTIVE.type
//        )
//        // if active field is not present and is true, consider active customer type
//        if (active.isPresent && active.get().toBoolean()) {
//            customerTypeField = arrayOf(
//                CustomerTypes.BILLING.type,
//                CustomerTypes.TRANSPORTATION.type
//            )
//            // if active field is not present and is false, consider inactive customer type
//        } else if (active.isPresent && !active.get().toBoolean()) {
//            customerTypeField = arrayOf(
//                CustomerTypes.INACTIVE.type
//            )
//        }
//
//        val sort: Sort = Sort.by(sortOrderField, sortByField)
//        return ServerResponse.ok().body(
//            customerService.getAllByCustomerIdOrAddressType(
//                deletedField.toBoolean(),
//                searchTextField,
//                searchTextField,
//                customerTypeField,
//                sort
//            )
//        )
//    }
}
