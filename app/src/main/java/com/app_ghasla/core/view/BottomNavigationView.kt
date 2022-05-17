package com.app_ghasla.core.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.app_ghasla.R
import com.app_ghasla.core.constant.emptyString
import com.app_ghasla.core.extension.getColor
import com.app_ghasla.core.model.common.BottomNavigationItem
import com.app_ghasla.databinding.ViewBottomNavigationBinding
import setBackgroundColorFilter
import setDrawableTint

class BottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var _binding: ViewBottomNavigationBinding? = null
    private val binding get() = _binding!!

    private var selectedItem: BottomNavigationItem? = null
    private var selectedItemListener: ((selectedItem: BottomNavigationItem) -> Unit)? = null

    init {
        initView()
    }

    private fun initView() {
        setBinding()
        setView()
    }

    private fun setBinding() {
        _binding = ViewBottomNavigationBinding.inflate(
            LayoutInflater.from(context), this, true
        )
    }

    private fun setView() = with(binding) {
        tvHome.setOnClickListener {
            onSelectedItem(BottomNavigationItem.Home)
        }
        tvOrders.setOnClickListener {
            onSelectedItem(BottomNavigationItem.Orders)
        }
        tvCoupons.setOnClickListener {
            onSelectedItem(BottomNavigationItem.Coupons)
        }
        tvQRCode.setOnClickListener {
            onSelectedItem(BottomNavigationItem.QRCode)
        }
    }

    private fun onSelectedItem(item: BottomNavigationItem) = with(binding) {
        if (selectedItem != null && selectedItem == item && selectedItem != BottomNavigationItem.QRCode) return
        selectedItem = item
        selectedItemListener?.invoke(item)
        updateItem(item)
    }

    /**
     * Selected Item Listener
     */
    fun setSelectedItemListener(listener: (selectedItem: BottomNavigationItem) -> Unit) {
        selectedItemListener = listener
    }

    /**
     * Items
     */
    private fun updateItem(item: BottomNavigationItem) {
        when (item) {
            BottomNavigationItem.Home -> {
                updateHomeItem(isSelected = true)
                updateOrderItem(isSelected = false)
                updateCouponsItem(isSelected = false)
                updateQRCodeItem(isSelected = false)
            }
            BottomNavigationItem.Orders -> {
                updateHomeItem(isSelected = false)
                updateOrderItem(isSelected = true)
                updateCouponsItem(isSelected = false)
                updateQRCodeItem(isSelected = false)
            }
            BottomNavigationItem.Coupons -> {
                updateHomeItem(isSelected = false)
                updateOrderItem(isSelected = false)
                updateCouponsItem(isSelected = true)
                updateQRCodeItem(isSelected = false)
            }
            BottomNavigationItem.QRCode -> {
                updateHomeItem(isSelected = false)
                updateOrderItem(isSelected = false)
                updateCouponsItem(isSelected = false)
                updateQRCodeItem(isSelected = true)
            }
        }
    }

    /**
     * Home Item
     */
    private fun updateHomeItem(isSelected: Boolean) = with(binding) {
        when (isSelected) {
            true -> tvHome.active(
                context.getString(R.string.bottomNavigation_item_home),
                R.color.bottom_view_home,
                R.color.bottom_view_home_background
            )
            false -> tvHome.normal()
        }
    }

    /**
     * Order Item
     */
    private fun updateOrderItem(isSelected: Boolean) = with(binding) {
        when (isSelected) {
            true -> tvOrders.active(
                context.getString(R.string.bottomNavigation_item_home),
                R.color.bottom_view_order,
                R.color.bottom_view_order_background
            )
            false -> tvOrders.normal()
        }
    }

    /**
     * Coupons Item
     */
    private fun updateCouponsItem(isSelected: Boolean) = with(binding) {
        when (isSelected) {
            true -> tvCoupons.active(
                context.getString(R.string.bottomNavigation_item_home),
                R.color.bottom_view_coupons,
                R.color.bottom_view_coupons_background
            )
            false -> tvCoupons.normal()
        }
    }

    /**
     * QRcode Item
     */
    private fun updateQRCodeItem(isSelected: Boolean) = with(binding) {
        when (isSelected) {
            true -> tvQRCode.active(
                context.getString(R.string.bottomNavigation_item_qrcode),
                R.color.bottom_view_coupons,
                R.color.bottom_view_coupons_background
            )
            false -> tvQRCode.normal()
        }
    }

    /**
     * TextView: Normal & Active
     */
    private fun TextView.normal() {
        text = emptyString
        setDrawableTint(R.color.blackPrimary)
        setTextColor(getColor(R.color.blackPrimary))
    }

    private fun TextView.active(name: String, nameColor: Int, backgroundColor: Int) {
        text = name
        setDrawableTint(nameColor)
        setTextColor(getColor(nameColor))
        setBackgroundColorFilter(backgroundColor)
    }

    /**
     * State
     */
    fun setState(item: BottomNavigationItem) {
        onSelectedItem(item)
    }
}