package com.cd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args)
    val groupLevel = "a"
    val dateTimeFormatter = "b"
    val sofferedDateTimeString = groupLevel+dateTimeFormatter
    val s = "abc"
//    println("$s.length is ${s.length}")

    println("$groupLevel $dateTimeFormatter ")
}