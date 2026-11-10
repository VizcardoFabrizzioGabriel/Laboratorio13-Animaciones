
package com.example.laboratorio13animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Laboratorio13AnimacionesTheme {
                ElanScreen()
            }
        }
    }
}

@Composable
fun ElanScreen() {
    var visible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Cream
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 26.dp, vertical = 20.dp),
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
                    text = "KOTLIN · COMPOSE",
                    color = Muted,
                    fontSize = 10.sp,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(38.dp))

            // Título del laboratorio
            Text(
                text = "Animaciones",
                color = Charcoal,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "con Jetpack Compose - Fabrizzio Vizcardo",
                color = Plum,
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Implementación de transiciones visuales\nmediante Kotlin y Android Studio.",
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 21.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Burgundy),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "01",
                        color = White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "EJERCICIO 1",
                    color = Burgundy,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color(0xFFD9CDD3))
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Animación de visibilidad",
                modifier = Modifier.fillMaxWidth(),
                color = Charcoal,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Uso de AnimatedVisibility para mostrar y ocultar elementos con transiciones suaves.",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Área de animación
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(24.dp))
                    .background(LightPlum)
                    .padding(18.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimatedVisibility(
                        visible = visible,
                        enter = fadeIn(
                            animationSpec = tween(600)
                        ) + scaleIn(
                            initialScale = 0.85f,
                            animationSpec = tween(600)
                        ) + slideInVertically(
                            initialOffsetY = { it / 6 },
                            animationSpec = tween(600)
                        ),
                        exit = fadeOut(
                            animationSpec = tween(400)
                        ) + scaleOut(
                            targetScale = 0.9f,
                            animationSpec = tween(400)
                        ) + slideOutVertically(
                            targetOffsetY = { it / 6 },
                            animationSpec = tween(400)
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(Burgundy)
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "ANIMACIÓN ACTIVA",
                                color = Color(0xFFE9C9D1),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp
                            )

                            Spacer(modifier = Modifier.height(18.dp))

                            Text(
                                text = "AnimatedVisibility",
                                color = White,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "El elemento se muestra mediante efectos de opacidad, escala y desplazamiento.",
                                color = Color(0xFFF2E5E9),
                                fontSize = 12.sp,
                                lineHeight = 19.sp,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(18.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                listOf("FADE IN", "SCALE IN", "SLIDE IN").forEach { effect ->
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(50))
                                            .background(Color(0xFF6F293D))
                                            .padding(
                                                horizontal = 9.dp,
                                                vertical = 7.dp
                                            )
                                    ) {
                                        Text(
                                            text = effect,
                                            color = White,
                                            fontSize = 8.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }

                    if (!visible) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "01",
                                color = Plum,
                                fontSize = 42.sp,
                                fontWeight = FontWeight.Light
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Elemento oculto",
                                color = Charcoal,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = "Pulsa el botón para iniciar la animación",
                                color = Muted,
                                fontSize = 11.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Estado
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (visible) Burgundy else Muted)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = if (visible) "ELEMENTO VISIBLE" else "ELEMENTO OCULTO",
                    color = Muted,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón
            Button(
                onClick = { visible = !visible },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Burgundy,
                    contentColor = White
                )
            ) {
                Text(
                    text = if (visible) "OCULTAR ELEMENTO" else "MOSTRAR ELEMENTO",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Autor permanente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFD9CDD3))
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Fabrizzio Vizcardo",
                color = Burgundy,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "DESARROLLO DE SOFTWARE · TECSUP",
                color = Muted,
                fontSize = 9.sp,
                letterSpacing = 1.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ElanPreview() {
    Laboratorio13AnimacionesTheme {
        ElanScreen()
    }
}
