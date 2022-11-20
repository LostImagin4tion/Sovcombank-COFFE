package io.lostimagin4tion.sovcombankchallenge.state

import android.content.Context
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Settings(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    private val _themeSetting =  MutableStateFlow(ThemeSetting.values()[sharedPreferences.getInt(THEME, 0)])
    val themeSetting: StateFlow<ThemeSetting> = _themeSetting
    fun changeThemeSetting(value: ThemeSetting) {
        sharedPreferences.edit { putInt(THEME, value.ordinal) }
        _themeSetting.value = value
    }

    companion object {
        private const val PREFERENCES_NAME = "settings"
        private const val THEME = "theme"
    }
}

enum class ThemeSetting {
    System,
    Light,
    Dark
}
