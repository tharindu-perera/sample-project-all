package com.cd


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class MonoApplication

fun main(args: Array<String>) {
    runApplication<MonoApplication>(*args)
}
