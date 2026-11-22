package br.tribein.utils

fun isValidEmail(email: String): Boolean {
    val emailPattern = "^[A-Za-z0-9+_.-]+@(.+)\$"
    return email.matches(Regex(emailPattern))
}