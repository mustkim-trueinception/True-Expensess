package ai.truelink.app.ui

import ai.truelink.app.core.data.dataStore.appSettings.AppSettings
import ai.truelink.app.core.data.dataStore.appSettings.AppSettingsStore
import ai.truelink.app.core.data.dataStore.appSettings.AppThemeMode
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val appSettingsStore: AppSettingsStore,
) : ViewModel() {
    lateinit var appSettings: AppSettings

    private val _uiMode = MutableStateFlow(AppThemeMode.System)
    val uiMode get() = _uiMode.asStateFlow()

    init {
        viewModelScope.launch {
            appSettings = appSettingsStore.getAppSettings()
            setUiTheme(appSettings.theme)
        }
    }

    fun setUiTheme(mode: AppThemeMode) = viewModelScope.launch {
        appSettingsStore.saveAppSettings(appSettings = appSettings.copy(theme = mode))
        _uiMode.value = mode
    }
}