package org.work.project.utils

import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.Settings

actual fun createSecureSettings(): Settings {
    return KeychainSettings("auth_tokens")
}