package com.cd.customer


import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class InterchangeKafkaListener(
     val mapper: ObjectMapper = ObjectMapper()
) {
    companion object {
        private const val X12 = "X12"
        private const val ST01_TRANSACTION_SET_IDENTIFIER_CODE = "ST01-TransactionSetIdentifierCode"
    }

    val successMessageCount = AtomicLong()
    val failedMessageCount = AtomicLong()

    private val transactionSetIdentifierCodePath = "$.$X12..$ST01_TRANSACTION_SET_IDENTIFIER_CODE"

    @KafkaListener(topics = arrayOf("test-topic"), groupId = "INTERCHANGE")
    fun receive(payload: String) {
        println("payload>>$payload")


    }
}
