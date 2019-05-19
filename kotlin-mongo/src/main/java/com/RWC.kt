package com

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class RWC (
        @Id
        val id: String? = null,
        @JsonIgnore
        val rwcId: String?= "xxx",
        val name: String,
        val railroadId: String = "",
        @JsonProperty("isLatest")
        @get:JsonProperty("isLatest")
        val isLatest: Boolean = false,
        val templateWaybill: SimpleWaybill
)

class RwcNotFoundException(message: String = "The specified RWC could not be found") : Exception(message)