package org.work.project.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
actual fun convertMillisToDate(millis: Long?):String{
    val formatter = DateTimeFormatter
        .ofLocalizedDate(FormatStyle.MEDIUM)
        .withLocale(Locale.getDefault())
    val date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault())
    return formatter.format(date)
}