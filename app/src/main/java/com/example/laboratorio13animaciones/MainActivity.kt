
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
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio13animaciones.ui.theme.Laboratorio13AnimacionesTheme

private val BackgroundDark = Color(0xFF080D19)
private val CardDark = Color(0xFF141E30)
private val NeonBlue = Color(0xFF38BDF8)
private val NeonPurple = Color(0xFF9B8CFF)
private val TextWhite = Color(0xFFF1F5F9)
private val TextMuted = Color(0xFF94A3B8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Laboratorio13AnimacionesTheme {
                MotionStudioScreen()
            }
        }
    }
}

@Composable
fun MotionStudioScreen() {

    var visible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        BackgroundDark,
                        Color(0xFF101A2D),
                        Color(0xFF090E19)
                    )
                )
            )
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ENCABEZADO
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "MOTION STUDIO",
                    color = NeonBlue,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 3.sp
                )

                Text(
                    text = "Animated Visibility",
                    color = TextWhite,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF1C2D45)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "01",
                    color = NeonBlue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Laboratorio 13 / Jetpack Compose",
            color = TextMuted,
            fontSize = 13.sp,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // PANEL PRINCIPAL
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = CardDark
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // ESTADO DE ANIMACIÓN
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ANIMATION PREVIEW",
                        color = TextMuted,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )

                    Surface(
                        shape = RoundedCornerShape(50),
                        color = if (visible)
                            Color(0xFF123B39)
                        else
                            Color(0xFF352333)
                    ) {
                        Text(
                            text = if (visible) "VISIBLE" else "HIDDEN",
                            color = if (visible)
                                Color(0xFF4ADE80)
                            else
                                Color(0xFFF472B6),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(
                                horizontal = 12.dp,
                                vertical = 6.dp
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // ÁREA DE ANIMACIÓN
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(22.dp))
                        .background(Color(0xFF0C1525)),
                    contentAlignment = Alignment.Center
                ) {

                    // COLUMN PROPORCIONA EL CONTEXTO COLUMN SCOPE
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AnimatedVisibility(
                            visible = visible,
                            enter = fadeIn(
                                animationSpec = tween(650)
                            ) + scaleIn(
                                initialScale = 0.75f,
                                animationSpec = spring(
                                    dampingRatio = 0.65f,
                                    stiffness = 180f
                                )
                            ) + slideInVertically(
                                initialOffsetY = { it / 3 },
                                animationSpec = tween(650)
                            ),
                            exit = fadeOut(
                                animationSpec = tween(350)
                            ) + scaleOut(
                                targetScale = 0.80f,
                                animationSpec = tween(350)
                            ) + slideOutVertically(
                                targetOffsetY = { it / 4 },
                                animationSpec = tween(350)
                            )
                        ) {

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                shape = RoundedCornerShape(24.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFF1B2D48)
                                )
                            ) {

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .size(62.dp)
                                            .clip(RoundedCornerShape(20.dp))
                                            .background(
                                                Brush.linearGradient(
                                                    listOf(
                                                        NeonBlue,
                                                        NeonPurple
                                                    )
                                                )
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "✦",
                                            color = Color.White,
                                            fontSize = 32.sp
                                        )
                                    }

                                    Spacer(
                                        modifier = Modifier.height(18.dp)
                                    )

                                    Text(
                                        text = "Animation Active",
                                        color = TextWhite,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(
                                        modifier = Modifier.height(8.dp)
                                    )

                                    Text(
                                        text = "The element is now visible",
                                        color = TextMuted,
                                        fontSize = 12.sp
                                    )

                                    Spacer(
                                        modifier = Modifier.height(18.dp)
                                    )

                                    Text(
                                        text = "FADE + SCALE + SLIDE",
                                        color = NeonBlue,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp
                                    )
                                }
                            }
                        }

                        // MENSAJE CUANDO NO HAY ELEMENTO VISIBLE
                        if (!visible) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "◌",
                                    color = TextMuted,
                                    fontSize = 48.sp
                                )

                                Spacer(
                                    modifier = Modifier.height(12.dp)
                                )

                                Text(
                                    text = "Waiting for animation",
                                    color = TextMuted,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "CONTROL PANEL",
                    color = TextMuted,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { visible = !visible },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (visible)
                            Color(0xFF293B55)
                        else
                            Color(0xFF1676B8)
                    )
                ) {
                    Text(
                        text = if (visible)
                            "OCULTAR ELEMENTO"
                        else
                            "MOSTRAR ELEMENTO",
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Pulsa el botón para iniciar la transición",
                    color = TextMuted,
                    fontSize = 11.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "JETPACK COMPOSE • ANIMATION MODULE",
            color = TextMuted,
            fontSize = 10.sp,
            letterSpacing = 1.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MotionStudioPreview() {
    Laboratorio13AnimacionesTheme {
        MotionStudioScreen()
    }
}
