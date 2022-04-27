package com.app_ghasla.core.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/**
 * Toast
 */
fun Context.showToast(
    message: String,
    duration: Int = Toast.LENGTH_LONG
) {
    Toast.makeText(this, message, duration).show()
}

fun Fragment.showToast(
    message: String,
    duration: Int = Toast.LENGTH_LONG
) {
    Toast.makeText(requireContext(), message, duration).show()
}

/**
 * Snackbar
 */
fun AppCompatActivity.showSnackbar(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(findViewById(android.R.id.content), message, duration).show()
}

fun AppCompatActivity.showSnackbar(
    message: String,
    anchorView: View? = null,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(findViewById(android.R.id.content), message, duration).apply {
        anchorView?.let { setAnchorView(it) }
        show()
    }
}

fun Fragment.showSnackbar(
    message: String,
    anchorView: View? = null,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(requireActivity().findViewById(android.R.id.content), message, duration).apply {
        anchorView?.let { setAnchorView(it) }
        show()
    }
}

fun View.showSnackbar(
    message: String,
    anchorView: View? = null,
    duration: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(this, message, duration).apply {
        anchorView?.let { setAnchorView(it) }
        show()
    }
}