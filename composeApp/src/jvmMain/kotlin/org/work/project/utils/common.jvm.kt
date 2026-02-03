package org.work.project.utils

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import java.util.prefs.Preferences

actual fun createSecureSettings(): Settings {
    return PreferencesSettings(Preferences.userRoot())
}