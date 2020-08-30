/*
 * Copyright (c) 2017 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of General Electric Company.
 * The software may be used and/or copied only with the written permission of
 * General Electric Company or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the software has been supplied.
 */

package com.cd.waybill

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WaybillInternalClientConfig {
    @Bean
    fun loadBalancedWebClientBuilder(): WebClient.Builder {
        return WebClient.builder()
    }
}
