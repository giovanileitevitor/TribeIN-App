package br.tribein.ui.screens.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.tribein.ui.theme.AppStrings
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.cos
import kotlin.math.sin

private val ScreenBackground = Color(0xFFDDF4EF)
private val RadarGreen = Color(0xFF15966F)
private val RadarDarkGreen = Color(0xFF087653)
private val RadarLine = Color(0xFF51B69A)
private val TextDark = Color(0xFF203137)
private val TextMuted = Color(0xFF778B87)

@Composable
fun SplashScreenRadar(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2200)
        onTimeout()
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .safeContentPadding()
    ) {
        Canvas(Modifier.fillMaxSize()) {
            val spacing = 18.dp.toPx()
            var y = 0f
            while (y < size.height) {
                var x = 0f
                while (x < size.width) {
                    drawCircle(
                        color = Color(0xFFD8E1DE),
                        radius = 0.8.dp.toPx(),
                        center = Offset(x, y)
                    )
                    x += spacing
                }
                y += spacing
            }
        }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFEAF6F3), Color(0xFFDDF5EF))
                    )
                )
        ) {
            val transition = rememberInfiniteTransition(label = "splashRadar")
            val radarRotation by transition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(3600, easing = LinearEasing),
                        repeatMode = RepeatMode.Restart
                    ),
                    label = "radarRotation"
                )
            val pulse by transition.animateFloat(
                    initialValue = 0.25f,
                    targetValue = 0.75f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(900, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "radarPulse"
                )
            val tagPositions = remember {
                RadarTagPositions.shuffled().take(5)
            }

            Canvas(Modifier.fillMaxSize()) {
                val center = Offset(size.width / 2f, size.height * 0.51f)
                val radius = minOf(size.width * 0.82f, size.height * 0.39f)

                drawCircle(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFDFF2ED), Color(0xFFC9F0E4)),
                        startY = center.y - radius,
                        endY = center.y + radius
                    ),
                    radius = size.maxDimension,
                    center = center
                )

                listOf(0.25f, 0.5f, 0.75f, 1f).forEach { ring ->
                    drawCircle(
                        color = RadarLine.copy(alpha = if (ring == 1f) 0.13f else 0.2f),
                        radius = radius * ring,
                        center = center,
                        style = Stroke(width = 1.dp.toPx())
                    )
                }
                val sweepPath = Path().apply {
                    moveTo(center.x, center.y)
                    arcTo(
                        rect = Rect(
                            center.x - radius,
                            center.y - radius,
                            center.x + radius,
                            center.y + radius
                        ),
                        startAngleDegrees = -28f,
                        sweepAngleDegrees = 48f,
                        forceMoveTo = false
                    )
                    close()
                }
                rotate(radarRotation, pivot = center) {
                    drawPath(
                        path = sweepPath,
                        brush = Brush.radialGradient(
                            colors = listOf(
                                RadarGreen.copy(alpha = 0.22f),
                                RadarGreen.copy(alpha = 0.1f),
                                RadarGreen.copy(alpha = 0.015f)
                            ),
                            center = center,
                            radius = radius
                        )
                    )
                }

                drawRadarBlip(center, radius, 0.56f, -0.55f, pulse)
                drawRadarBlip(center, radius, -0.86f, -0.39f, pulse)
                drawRadarBlip(center, radius, 0.42f, -0.12f, pulse)
                drawRadarBlip(center, radius, -0.95f, 0.48f, pulse)
                drawRadarBlip(center, radius, 0.62f, 0.78f, pulse)
                drawRadarBlip(center, radius, 0.0f, 0.0f, pulse)
            }

            RadarTarget(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = maxHeight * 0.01f),
                pulse = pulse
            )

            listOf("#gastro", "#track", "#music", "#movie", "#travel")
                .forEachIndexed { index, label ->
                    val position = tagPositions[index]
                    RadarTag(
                        label = label,
                        modifier = Modifier.offset(
                            x = maxWidth * position.x,
                            y = maxHeight * position.y
                        )
                    )
                }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 14.dp, vertical = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BrandHeader()
                Spacer(Modifier.weight(1f))
                FooterCard()
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "App Version: ${AppStrings.APP_VERSION}",
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.68f))
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    color = TextMuted,
                    fontSize = 8.sp,
                    letterSpacing = 0.3.sp
                )
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawRadarBlip(
    center: Offset,
    radius: Float,
    xFraction: Float,
    yFraction: Float,
    pulse: Float
) {
    val point = Offset(
        center.x + radius * xFraction,
        center.y + radius * yFraction
    )
    drawCircle(
        color = RadarGreen.copy(alpha = 0.12f * pulse),
        radius = 11.dp.toPx(),
        center = point
    )
    drawCircle(color = RadarGreen, radius = 3.dp.toPx(), center = point)
}

@Composable
private fun BrandHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .shadow(4.dp, CircleShape)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.94f))
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(19.dp)
                    .background(RadarGreen, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                RadarGlyph(Modifier.size(13.dp))
            }
            Spacer(Modifier.width(7.dp))
            Text(
                text = "Tribe IN",
                color = TextDark,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(RadarGreen, CircleShape)
            )
        }
        Spacer(Modifier.height(6.dp))
        Text(
            text = "O mundo é feito de conexões",
            color = Color(0xFF5D716D),
            fontSize = 9.sp
        )
    }
}

@Composable
private fun RadarGlyph(modifier: Modifier = Modifier) {
    Canvas(modifier) {
        val center = Offset(size.width / 2f, size.height / 2f)
        val orbitRadius = size.minDimension * 0.27f
        for (index in 0 until 6) {
            val angle = index * (2f * PI_FLOAT / 6f)
            val node = Offset(
                center.x + cos(angle) * orbitRadius,
                center.y + sin(angle) * orbitRadius
            )
            drawLine(Color.White, center, node, 1.dp.toPx())
            drawCircle(Color.White, 1.35.dp.toPx(), node)
        }
        drawCircle(Color.White, 1.7.dp.toPx(), center)
    }
}

@Composable
private fun RadarTarget(modifier: Modifier = Modifier, pulse: Float) {
    Box(
        modifier = modifier
            .size(19.dp)
            .background(RadarGreen.copy(alpha = 0.12f + pulse * 0.12f), CircleShape)
            .padding(3.dp)
            .background(Color.White, CircleShape)
            .padding(2.dp)
            .background(RadarGreen, CircleShape)
    )
}

@Composable
private fun RadarTag(label: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(6.dp)
                .background(RadarGreen, CircleShape)
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = label,
            modifier = Modifier
                .shadow(2.dp, CircleShape)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.92f))
                .padding(horizontal = 7.dp, vertical = 3.dp),
            color = RadarDarkGreen,
            fontSize = 8.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun FooterCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.62f))
            .padding(horizontal = 12.dp, vertical = 9.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Descubra quem vibra na sua frequência",
            color = TextMuted,
            fontSize = 8.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = AppStrings.SPLASH_COPYRIGHT,
            color = TextMuted.copy(alpha = 0.78f),
            fontSize = 7.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun PreviewSplashScreen() {
    MaterialTheme {
        SplashScreenRadar(onTimeout = {})
    }
}

private const val PI_FLOAT = 3.1415927f

private data class RadarTagPosition(val x: Float, val y: Float)

private val RadarTagPositions = listOf(
    RadarTagPosition(0.03f, 0.20f),
    RadarTagPosition(0.60f, 0.20f),
    RadarTagPosition(0.03f, 0.31f),
    RadarTagPosition(0.60f, 0.31f),
    RadarTagPosition(0.03f, 0.42f),
    RadarTagPosition(0.60f, 0.42f),
    RadarTagPosition(0.03f, 0.53f),
    RadarTagPosition(0.60f, 0.53f),
    RadarTagPosition(0.03f, 0.64f),
    RadarTagPosition(0.60f, 0.64f),
    RadarTagPosition(0.03f, 0.75f),
    RadarTagPosition(0.60f, 0.75f)
)
