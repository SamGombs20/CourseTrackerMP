package org.work.project.utils

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSDateFormatterMediumStyle
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.dateWithTimeIntervalSince1970

actual fun convertMillisToDate(millis: Long?): String {
    val formatter = NSDateFormatter().apply {
        dateStyle = NSDateFormatterMediumStyle
        locale = NSLocale.currentLocale
    }
    val date = NSDate.dateWithTimeIntervalSince1970(millis!!/1000.0)
    return formatter.stringFromDate(date)
}