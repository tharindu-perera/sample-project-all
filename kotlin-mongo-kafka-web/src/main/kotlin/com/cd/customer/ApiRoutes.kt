package com.cd.web

import com.cd.customer.CustomerRoutes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

/**
 * This class serves as a place to compose varies service routes into a single `RouterFunction`.
 */
@Configuration
class ApiRoutes(

    val customerRoutes: CustomerRoutes


) {

    @Bean
    fun routes(): RouterFunction<ServerResponse> {
        return router {

            customerRoutes()()

        }
    }
}
