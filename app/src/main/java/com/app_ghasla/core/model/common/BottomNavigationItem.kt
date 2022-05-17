package com.app_ghasla.core.model.common

import com.app_ghasla.core.constant.emptyString

enum class BottomNavigationItem(
    val tag: String,
    val navGraph: Int
) {
    Home(
        tag = "bottom_home_item",
        navGraph = -1
    ),
    Orders(
        tag = "bottom_orders_item",
        navGraph = -1
    ),
    Coupons(
        tag = "bottom_coupons_item",
        navGraph = -1
    ),
    QRCode(
        tag = emptyString,
        navGraph = -1
    )
}