package com

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter

/**
 * This allows a model to deserialize and serialize additional fields on the model. The effect of this being that
 * additional fields can be sent, persisted, and retrieved without making any changes to the model. The JSON object
 * returned by a query will be structurally identical to what was passed in. To explicitly call out unknown fields as
 * additional use [SupportsUnknownFieldsAsAdditionalFields].
 *
 * Usage: To support unknown json fields, add the property below to the primary constructor.
 *
 * ```
 *     @JsonIgnore
 *     override val unknownFields: MutableMap<String, Any> = mutableMapOf()
 * ```
 */
interface SupportsUnknownFieldsTransparently {
    /**
     * This is a map of all data that we receive that does not have an explicit mapping to the model.
     */
    val unknownFields: MutableMap<String, Any>

    @JsonAnyGetter
    fun getUnknownFieldMap(): Map<String, Any> {
        return unknownFields
    }

    @JsonAnySetter
    fun setUnknownField(name: String, value: Any) {
        unknownFields[name] = value
    }
}

/**
 * This allows a model to support the addition of arbitrary fields. Unlike [SupportsUnknownFieldsTransparently] these
 * unknown fields are explicitly called out as being 'additional'; the JSON object returned by a query will be
 * structurally **different** to what was passed in. All fields that do not have an explicit mapping will be placed into
 * an [additionalFields] map.
 *
 * Usage: To support unknown json fields, add the property below to the primary constructor.
 *
 * ```
 *     override val additionalFields: MutableMap<String, Any> = mutableMapOf()
 * ```
 */
interface SupportsUnknownFieldsAsAdditionalFields {
    /**
     * This is a map of all data that we receive that does not have an explicit mapping to the model.
     */
    val additionalFields: MutableMap<String, Any?>

    @JsonAnySetter
    fun setAdditionalFields(name: String, value: Any) {
        additionalFields[name] = value
    }
}