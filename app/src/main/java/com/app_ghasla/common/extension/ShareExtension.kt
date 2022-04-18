package com.app_ghasla.common.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.app_ghasla.common.constant.emptyString

fun Context.shareFile(mimeType: String, file: Uri) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        type = mimeType
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        putExtra(Intent.EXTRA_STREAM, file)
    }
    startActivity(Intent.createChooser(shareIntent, emptyString))
}

fun Context.shareFiles(mimeType: String, files: ArrayList<Uri>) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND_MULTIPLE
        type = mimeType
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        putParcelableArrayListExtra(Intent.EXTRA_STREAM, files)
    }
    startActivity(Intent.createChooser(shareIntent, emptyString))
}