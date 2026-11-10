
package com.example.laboratorio13animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio13animaciones.ui.theme.Laboratorio13AnimacionesTheme

private val Cream = Color(0xFFF6F2EC)
private val Burgundy = Color(0xFF852E45)
private val Plum = Color(0xFF72516F)
private val LightPlum = Color(0xFFEAE1EA)
private val Charcoal = Color(0xFF29242A)
private val Muted = Color(0xFF89818A)
private val White = Color(0xFFFFFDFC)
private val DarkBackground = Color(0xFF29232D)
private val DarkCard = Color(0xFF493747)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Laboratorio13AnimacionesTheme {
                CombinedAnimationsScreen()
            }
        }
    }
}

@Composable
fun CombinedAnimationsScreen() {
    var expanded by remember { mutableStateOf(false) }
    var showActionButton by remember { mutableStateOf(true) }
    var isDark by remember { mutableStateOf(false) }

    // Animación del tamaño
    val animatedSize by animateDpAsState(
        targetValue = if (expanded) 125.dp else 85.dp,
        animationSpec = spring(),
        label = "SizeAnimation"
    )

    // Animación del color
    val animatedColor by animateColorAsState(
        targetValue = if (expanded) Plum else Burgundy,
        animationSpec = tween(durationMillis = 800),
        label = "ColorAnimation"
    )

    // Animación repetitiva
    val infiniteTransition = rememberInfiniteTransition(
        label = "InfiniteAnimation"
    )

    val pulse by infiniteTransition.animateFloat(
        initialValue = 0.55f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "PulseAnimation"
    )

    // Transición del fondo entre modos
    val backgroundColor by animateColorAsState(
        targetValue = if (isDark) DarkBackground else Cream,
        animationSpec = tween(durationMillis = 700),
        label = "BackgroundAnimation"
    )

    val textColor = if (isDark) White else Charcoal
    val secondaryColor = if (isDark) Color(0xFFC9BACB) else Muted
    val cardBackground = if (isDark) DarkCard else LightPlum

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 22.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Encabezado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "LABORATORIO 13",
                    color = Burgundy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                )

                Text(
                    text = "EJERCICIO FINAL",
                    color = secondaryColor,
                    fontSize = 10.sp,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Animaciones",
                color = textColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "combinadas",
                color = Plum,
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Integración de efectos y transiciones\ncon Jetpack Compose.",
                color = secondaryColor,
                fontSize = 12.sp,
                lineHeight = 19.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Indicador animado
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .alpha(pulse)
                        .clip(CircleShape)
                        .background(Burgundy)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "SISTEMA DE ANIMACIONES ACTIVO",
                    color = secondaryColor,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Área principal
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(22.dp))
                    .background(cardBackground)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 1. Animación de tamaño y color
                Text(
                    text = "01 · TAMAÑO Y COLOR",
                    color = Plum,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier.size(145.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(animatedSize)
                            .clip(RoundedCornerShape(20.dp))
                            .background(animatedColor)
                            .clickable {
                                expanded = !expanded
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (expanded) "ACTIVO" else "PULSAR",
                            color = White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    }
                }

                Text(
                    text = "Pulsa el cuadro para cambiar su tamaño y color.",
                    color = secondaryColor,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(18.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFBBAAB8))
                )

                Spacer(modifier = Modifier.height(14.dp))

                // 2. Animación de visibilidad
                Text(
                    text = "02 · ANIMATED VISIBILITY",
                    color = Plum,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                AnimatedVisibility(
                    visible = showActionButton,
                    enter = fadeIn(
                        animationSpec = tween(500)
                    ) + slideInVertically(
                        initialOffsetY = { it },
                        animationSpec = tween(600)
                    ),
                    exit = fadeOut(
                        animationSpec = tween(400)
                    ) + slideOutVertically(
                        targetOffsetY = { it },
                        animationSpec = tween(500)
                    )
                ) {
                    Button(
                        onClick = {
                            showActionButton = false
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Burgundy,
                            contentColor = White
                        )
                    ) {
                        Text(
                            text = "OCULTAR BOTÓN",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                if (!showActionButton) {
                    Button(
                        onClick = {
                            showActionButton = true
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Plum,
                            contentColor = White
                        )
                    ) {
                        Text(
                            text = "MOSTRAR BOTÓN",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFFBBAAB8))
                )

                Spacer(modifier = Modifier.height(14.dp))

                // 3. Cambio de tema
                Text(
                    text = "03 · CAMBIO DE TEMA",
                    color = Plum,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                AnimatedContent(
                    targetState = isDark,
                    transitionSpec = {
                        fadeIn(
                            animationSpec = tween(600)
                        ) togetherWith fadeOut(
                            animationSpec = tween(400)
                        )
                    },
                    label = "ThemeTransition"
                ) { darkMode ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(
                                if (darkMode) DarkBackground else White
                            )
                            .padding(14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (darkMode) {
                                "Modo oscuro"
                            } else {
                                "Modo claro"
                            },
                            color = if (darkMode) White else Charcoal,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = if (darkMode) {
                                "Una apariencia más tenue."
                            } else {
                                "Una apariencia luminosa."
                            },
                            color = if (darkMode) {
                                Color(0xFFC9BACB)
                            } else {
                                Muted
                            },
                            fontSize = 10.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        isDark = !isDark
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Plum,
                        contentColor = White
                    )
                ) {
                    Text(
                        text = if (isDark) {
                            "ACTIVAR MODO CLARO"
                        } else {
                            "ACTIVAR MODO OSCURO"
                        },
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Autor permanente
            Text(
                text = "Fabrizzio Vizcardo",
                color = if (isDark) White else Burgundy,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "DESARROLLO DE SOFTWARE · TECSUP",
                color = secondaryColor,
                fontSize = 9.sp,
                letterSpacing = 1.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CombinedAnimationsPreview() {
    Laboratorio13AnimacionesTheme {
        CombinedAnimationsScreen()
    }
}
