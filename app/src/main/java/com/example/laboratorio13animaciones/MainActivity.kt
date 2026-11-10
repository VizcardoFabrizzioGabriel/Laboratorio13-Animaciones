
package com.example.laboratorio13animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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

private enum class ScreenState(
    val title: String,
    val description: String
) {
    Loading(
        "Cargando información",
        "Estamos preparando los datos solicitados."
    ),
    Content(
        "Contenido disponible",
        "La información se ha cargado correctamente."
    ),
    Error(
        "Ocurrió un error",
        "No fue posible completar la solicitud."
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Laboratorio13AnimacionesTheme {
                AnimatedContentScreen()
            }
        }
    }
}

@Composable
fun AnimatedContentScreen() {
    var currentState by remember {
        mutableStateOf(ScreenState.Loading)
    }

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
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Título
            Text(
                text = "Animaciones",
                color = Charcoal,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "con Jetpack Compose - Fabrizzio Vizcardo",
                color = Plum,
                fontSize = 23.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Transiciones entre diferentes estados\ny contenidos de una interfaz.",
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 21.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Identificación del ejercicio
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
                        text = "04",
                        color = White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "EJERCICIO 4",
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
                text = "Cambio de contenido",
                modifier = Modifier.fillMaxWidth(),
                color = Charcoal,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Uso de AnimatedContent para realizar transiciones entre estados.",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Área de transición
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(24.dp))
                    .background(LightPlum)
                    .padding(18.dp),
                contentAlignment = Alignment.Center
            ) {
                AnimatedContent(
                    targetState = currentState,
                    transitionSpec = {
                        fadeIn(
                            animationSpec = tween(600)
                        ) togetherWith fadeOut(
                            animationSpec = tween(350)
                        )
                    },
                    label = "ContentTransition"
                ) { state ->

                    val stateColor = when (state) {
                        ScreenState.Loading -> Plum
                        ScreenState.Content -> Color(0xFF58765E)
                        ScreenState.Error -> Burgundy
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .background(stateColor)
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = when (state) {
                                ScreenState.Loading -> "01"
                                ScreenState.Content -> "02"
                                ScreenState.Error -> "03"
                            },
                            color = White,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Light
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = state.title,
                            color = White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = state.description,
                            color = Color(0xFFF2E5E9),
                            fontSize = 13.sp,
                            lineHeight = 20.sp,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = when (state) {
                                ScreenState.Loading -> "ESTADO DE CARGA"
                                ScreenState.Content -> "ESTADO EXITOSO"
                                ScreenState.Error -> "ESTADO DE ERROR"
                            },
                            color = White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.5.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "SELECCIONA UN ESTADO",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Botones de los tres estados
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ScreenState.entries.forEach { state ->
                    Button(
                        onClick = { currentState = state },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(11.dp),
                        contentPadding = PaddingValues(horizontal = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (currentState == state) {
                                Burgundy
                            } else {
                                White
                            },
                            contentColor = if (currentState == state) {
                                White
                            } else {
                                Burgundy
                            }
                        )
                    ) {
                        Text(
                            text = when (state) {
                                ScreenState.Loading -> "CARGANDO"
                                ScreenState.Content -> "CONTENIDO"
                                ScreenState.Error -> "ERROR"
                            },
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
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
                fontWeight = FontWeight.Bold
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
fun AnimatedContentPreview() {
    Laboratorio13AnimacionesTheme {
        AnimatedContentScreen()
    }
}
