package com.app_ghasla.core.extension

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 * Camera Permissions
 */
val cameraPermissions = arrayOf(
    Manifest.permission.CAMERA,
    Manifest.permission.RECORD_AUDIO
)

fun Context.isCameraPermissionsGranted() = cameraPermissions.all {
    ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
}

/**
 * Storage Permission
 */
const val storagePermission = Manifest.permission.WRITE_EXTERNAL_STORAGE

fun Context.isStoragePermissionGranted(): Boolean {
    return ContextCompat.checkSelfPermission(this, storagePermission) ==
            PackageManager.PERMISSION_GRANTED
}