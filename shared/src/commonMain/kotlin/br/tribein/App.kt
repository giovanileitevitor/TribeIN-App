package br.tribein

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import br.tribein.di.appModule
import br.tribein.ui.navigation.NavGraph
import br.tribein.ui.theme.rememberRobotoFontFamily
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import coil3.svg.SvgDecoder
import org.koin.compose.KoinContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.mp.KoinPlatformTools

@Composable
fun App() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .components {
                add(KtorNetworkFetcherFactory())
                add(SvgDecoder.Factory())
            }
            .crossfade(true)
            .build()
    }

    MaterialTheme {
        CompositionLocalProvider(
            LocalTextStyle provides MaterialTheme.typography.bodyLarge.copy(
                fontFamily = rememberRobotoFontFamily()
            )
        ) {
            KoinContext {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

fun initKoin(config: KoinAppDeclaration? = null) {
    if (KoinPlatformTools.defaultContext().getOrNull() == null) {
        startKoin {
            config?.invoke(this)
            modules(appModule)
        }
    }
}