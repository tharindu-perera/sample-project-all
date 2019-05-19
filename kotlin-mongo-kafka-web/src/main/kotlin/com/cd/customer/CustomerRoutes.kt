package com.cd.customer

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunctionDsl

@Component
class CustomerRoutes(
    val customerWebHandlers: CustomerWebHandlers

) {
    companion object {
        const val CUSTOMER_ID = "id"
        const val CUSTOMER_INDUSTRY_REFERENCE_ID = "customerIrfId"
        const val CUSTOMER_INDUSTRY_REFERENCE_NAME = "customerIrfName"
        const val BASE_PATH = "/customer"
        const val SEARCH_VAL = "searchVal"
        const val SORT_BY = "sortBy"
        const val SORT_ORDER = "sortOrder"
        const val DELETED = "deleted"
        const val ACTIVE = "active"
        const val IRF = "/irf"
    }

    operator fun invoke(): RouterFunctionDsl.() -> Unit {
        return {
            BASE_PATH.nest {
                GET("/", customerWebHandlers::getAll)
                GET("/{$CUSTOMER_ID}", customerWebHandlers::getById)
//                GET("/search/customer", customerWebHandlers::getAllByCustomerIdOrAddressType)
                POST("/", customerWebHandlers::create)
                PUT("/{$CUSTOMER_ID}", customerWebHandlers::update)
                }
            }
        }
    }


