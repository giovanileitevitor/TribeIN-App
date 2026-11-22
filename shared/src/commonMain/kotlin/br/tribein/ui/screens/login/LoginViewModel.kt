package br.tribein.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.tribein.ui.screens.login.states.LoginUiState
import br.tribein.utils.GlobalKeys.KEY_EMAIL
import br.tribein.utils.GlobalKeys.KEY_PASSWORD
import br.tribein.utils.GlobalKeys.KEY_REMEMBER_ME
import br.tribein.utils.isValidEmail
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class LoginViewModel(
    //private val baseApi: BaseApi,
    private val settings: Settings
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        LoginUiState(
            email = settings.getString(KEY_EMAIL, ""),
            password = settings.getString(KEY_PASSWORD, ""),
            rememberMe = settings.getBoolean(KEY_REMEMBER_ME, false)
        )
    )
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()
    private var fetchJob: Job? = null

    fun updateEmail(email: String) {
        _uiState.update { it.copy(email = email, error = null) }
        if (_uiState.value.rememberMe) {
            settings[KEY_EMAIL] = email
        }
    }

    fun updatePassword(password: String) {
        _uiState.update { it.copy(password = password, error = null) }
        if (_uiState.value.rememberMe) {
            settings[KEY_PASSWORD] = password
        }
    }

    fun toggleRememberMe() {
        _uiState.update { state ->
            val newRememberMe = !state.rememberMe
            settings[KEY_REMEMBER_ME] = newRememberMe

            if (newRememberMe) {
                settings[KEY_EMAIL] = state.email
                settings[KEY_PASSWORD] = state.password
            } else {
                settings.remove(KEY_EMAIL)
                settings.remove(KEY_PASSWORD)
            }
            state.copy(rememberMe = newRememberMe)
        }
    }

    fun togglePasswordVisibility() {
        _uiState.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun login(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val currentState = _uiState.value

        // Validation
        if (currentState.email.isEmpty()) {
            _uiState.update { it.copy(error = "Email é obrigatório") }
            onError("Email é obrigatório")
            return
        }

        if (!isValidEmail(currentState.email)) {
            _uiState.update { it.copy(error = "Email inválido") }
            onError("Email inválido")
            return
        }

        if (currentState.password.isEmpty()) {
            _uiState.update { it.copy(error = "Senha é obrigatória") }
            onError("Senha é obrigatória")
            return
        }

        if (currentState.password.length < 6) {
            _uiState.update { it.copy(error = "Senha deve ter no mínimo 6 caracteres") }
            onError("Senha deve ter no mínimo 6 caracteres")
            return
        }

        _uiState.update { it.copy(isLoading = true) }

        fetchJob?.cancel()
        fetchJob = viewModelScope.launch() {
            try {

            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message ?: "Erro ao fazer login") }
                onError(e.message ?: "Erro ao fazer login")
            }
        }

    }


}
