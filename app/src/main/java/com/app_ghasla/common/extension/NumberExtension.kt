package com.app_ghasla.common.extension

import com.app_ghasla.common.constant.emptyString

fun Long.getDiscountPercent(discountedPrice: Long): String {
    return when (discountedPrice == 0L) {
        true -> emptyString
        false -> "-${(100 * (this - discountedPrice) / this).toInt()}%"
    }
}