package br.tribein

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform