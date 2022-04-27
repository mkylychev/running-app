package com.app_ghasla.data.notification

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.app_ghasla.MainActivity
import com.app_ghasla.R
import com.app_ghasla.core.constant.emptyString

class NotificationService(private val context: Context) {

    private val notificationManager by lazy {
        NotificationManagerCompat.from(context)
    }

    /**
     * Pending Intents
     */
    private val openMainScreenPendingIntent: PendingIntent
        get() = Intent(context, MainActivity::class.java).run {
            PendingIntent.getActivity(
                context,
                0,
                this,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        }

    /**
     * Notification: Show
     */
    fun showNotification(
        id: Int,
        title: String = emptyString,
        description: String = emptyString
    ) = runCatching {
        notificationManager.notify(id, createNotification(title, description))
    }

    fun showGroupNotification(
        id: Int,
        groupId: Int = NOTIFICATION_GROUP_ID,
        title: String = emptyString,
        description: String = emptyString
    ) = runCatching {
        notificationManager.notify(id, createNotification(title, description))
        notificationManager.notify(groupId, createNotificationGroup(title, description))
    }

    /**
     * Notification: Create
     */
    private fun createNotification(
        title: String = emptyString,
        description: String = emptyString
    ): Notification {
        val notificationBuilder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setColor(context.getColor(R.color.white))
            .setGroup(NOTIFICATION_GROUP_KEY)
            .setStyle(NotificationCompat.BigTextStyle().bigText(description))
            .setContentIntent(openMainScreenPendingIntent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel().also {
                notificationBuilder.setChannelId(it.id)
            }
        }
        return notificationBuilder.build()
    }

    /**
     * Notification: Remove
     */
    fun removeNotification(id: Int) = runCatching {
        notificationManager.cancel(id)
    }

    fun removeAllNotifications() = runCatching {
        notificationManager.cancelAll()
    }

    /**
     * Notification Channel
     */
    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() = NotificationChannel(
        NOTIFICATION_CHANNEL_ID,
        NOTIFICATION_CHANNEL_NAME,
        NotificationManager.IMPORTANCE_LOW
    ).also {
        notificationManager.createNotificationChannel(it)
    }

    /**
     * Notification Group
     */
    private fun createNotificationGroup(
        title: String = emptyString,
        description: String = emptyString
    ): Notification {
        val notificationBuilder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setColor(context.getColor(R.color.white))
            .setGroup(NOTIFICATION_GROUP_KEY)
            .setGroupSummary(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText(description))
            .setContentIntent(openMainScreenPendingIntent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel().also {
                notificationBuilder.setChannelId(it.id)
            }
        }
        return notificationBuilder.build()
    }

    companion object {
        val NOTIFICATION_GROUP_ID = "Ghasla".hashCode()
        const val NOTIFICATION_GROUP_KEY = "Ghasla"
        const val NOTIFICATION_CHANNEL_ID = "Ghasla"
        const val NOTIFICATION_CHANNEL_NAME = "Ghasla"
    }
}