package com.cd.customer

import org.springframework.http.HttpMethod
import org.springframework.web.reactive.function.client.WebClient

class ThingParser (val stre:String ){
    operator fun invoke(str:String){
       println(str)
    }

}
fun main(args: Array<String>) {

    a:Int = "ff"!=null?:2

     ThingParser("fff")("ccccc")





    val requestSpec1 = WebClient
            .create("http://localhost:8085")
            .method(HttpMethod.GET)
            .uri("/customer/5c6a9693aaaab51bd2625cb5")
            .retrieve().bodyToFlux(Customer::class.java)

            .blockFirst()


    println(requestSpec1 )


    }
