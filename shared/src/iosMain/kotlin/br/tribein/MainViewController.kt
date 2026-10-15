package br.tribein

import androidx.compose.ui.uikit.OnFocusBehavior
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController (
    configure = {
        onFocusBehavior = OnFocusBehavior.DoNothing
    }
){
    initKoin()
    //requestStartupPermissions()
    App()
}