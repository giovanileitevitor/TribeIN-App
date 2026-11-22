package br.tribein.ui.screens.login.states

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val userId: String? = null,
    val rememberMe: Boolean = false,
    val passwordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
