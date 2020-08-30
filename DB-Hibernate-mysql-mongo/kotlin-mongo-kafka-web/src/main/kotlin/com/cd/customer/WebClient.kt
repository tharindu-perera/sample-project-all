/*
 * Copyright (c) 2017 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of General Electric Company.
 * The software may be used and/or copied only with the written permission of
 * General Electric Company or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the software has been supplied.
 */

package com.cd.customer

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

/**
 * Setup the client: Just make sure spring has this and `InterchangeInternalClientConfig` (which provides a eureka aware
 * `WebClient.Builder`) on the config path.
 *
 * Use the client: Inject the InterchangeInternalClient into a bean and use it.
 *
 * ```
 * @Component
 * class SomeClass(val exampleInternalClient: InterchangeInternalClient) {
 *     fun callTheClient(): Mono<Example> {
 *         return exampleInternalClient.create(Mono.just(Example(null, null, null)))
 *     }
 * }
 * ```
 */
@Component
class WebClient(
    private val webClientBuilder: WebClient.Builder,
    @Value("\${monoapp.service.host}") val monoAppHost: String

) {

    companion object {
        private const val BASE_PATH = "/api/v1/waybill"
    }

    fun getById(id :String): Mono<String> {
        return webClientBuilder
            .baseUrl("http://$monoAppHost")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("x-userinfo", "ccc")
            .build()
            .get()
            .uri("")
//            .body(BodyInserters.fromObject(id))
            .retrieve().bodyToMono(String::class.java)
    }




}

