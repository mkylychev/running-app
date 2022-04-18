package com.app_ghasla.common.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Json to Object
 */
inline fun <reified T> String.jsonToObject(): T? = runCatching {
    return Gson().fromJson(this, object : TypeToken<T>() {}.type)
}.getOrNull()

/**
 * Object to Json
 */
fun Any.objectToJson(): String? = runCatching {
    return Gson().toJson(this)
}.getOrNull()