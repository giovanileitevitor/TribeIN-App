package br.tribein.ui.screens.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.tribein.ui.theme.AppStrings
import br.tribein.ui.theme.Green90Dark
import br.tribein.ui.theme.GreenHalfDark
import br.tribein.ui.theme.GreenLightSaber
import br.tribein.ui.theme.ZigbeeDeepGreen
import br.tribein.ui.theme.ZigbeeGreen
import br.tribein.ui.theme.ZigbeeText
import br.tribein.ui.theme.gradient_end
import br.tribein.ui.theme.gradient_init
import br.tribein.ui.theme.gradient_mid
import br.tribein.ui.theme.rememberRobotoFontFamily
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun SplashScreenZigbee(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(1000.milliseconds)
        onTimeout()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(
                        gradient_init,
                        gradient_mid,
                        gradient_end
                    )
                )
            )
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Spacer(Modifier.weight(0.9f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            BrandLockup()
            Spacer(Modifier.height(16.dp))
            Text(
                text = "O mundo é feito de conexões",
                color = GreenHalfDark,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(20.dp))
            ZigbeeLoadingDots()
        }

        Column(
            modifier = Modifier.padding(bottom = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "COPYRIGHT RESERVED TO TRIBEIN.",
                color = Green90Dark,
                fontSize = 8.sp,
                letterSpacing = 0.4.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(3.dp))
            Text(
                text = "App Version: ${AppStrings.APP_VERSION}",
                color = Green90Dark,
                fontSize = 8.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(13.dp))
            Box(
                modifier = Modifier
                    .width(76.dp)
                    .height(3.dp)
                    .clip(CircleShape)
                    .background(GreenLightSaber)
            )
        }
    }
}

@Composable
private fun BrandLockup() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
//        Box(
//            modifier = Modifier
//                .size(54.dp)
//                .shadow(12.dp, RoundedCornerShape(18.dp))
//                .clip(RoundedCornerShape(18.dp))
//                .background(Color.White),
//            contentAlignment = Alignment.Center
//        ) {
//
//        }
        Spacer(Modifier.width(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Tribe",
                color = ZigbeeText,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.25).sp,
                fontFamily = rememberRobotoFontFamily()
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = "IN",
                modifier = Modifier
                    .clip(RoundedCornerShape(0.dp))
                    .background(Color.White.copy(alpha = 0.82f))
                    .padding(horizontal = 5.dp, vertical = 1.dp),
                color = ZigbeeDeepGreen,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (+2).sp,
                fontFamily = rememberRobotoFontFamily()
            )
            Spacer(Modifier.width(7.dp))
        }
    }
}



@Composable
private fun ZigbeeLoadingDots() {
    val transition = rememberInfiniteTransition(label = "zigbeeLoading")
    Row(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) { index ->
            val alpha by transition.animateFloat(
                initialValue = 0.25f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 650,
                        delayMillis = index * 180,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "zigbeeDot$index"
            )
            Box(
                modifier = Modifier
                    .size(if (index == 1) 26.dp else 5.dp, 3.dp)
                    .alpha(alpha)
                    .clip(CircleShape)
                    .background(if (index == 1) Color(0xFF9BE9D1) else ZigbeeGreen)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSplashScreenZigbee() {
    MaterialTheme {
        SplashScreenZigbee(onTimeout = {})
    }
}
