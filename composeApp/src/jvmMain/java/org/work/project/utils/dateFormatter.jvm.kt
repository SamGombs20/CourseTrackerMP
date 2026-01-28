package org.work.project.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale


actual fun convertMillisToDate(millis: Long?): String {
        val formatter = DateTimeFormatter
            .ofLocalizedDate(FormatStyle.MEDIUM)
            .withLocale(Locale.getDefault())

        val date = Instant
            .ofEpochMilli(millis)
            .atZone(ZoneId.systemDefault())

        return formatter.format(date)
    }
