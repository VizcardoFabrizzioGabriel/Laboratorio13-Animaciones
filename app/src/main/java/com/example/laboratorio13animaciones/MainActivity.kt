
package com.example.laboratorio13animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
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
                SizePositionScreen()
            }
        }
    }
}

@Composable
fun SizePositionScreen() {
    var expanded by remember { mutableStateOf(false) }
    var offsetFirst by remember { mutableStateOf(true) }

    // Animación del tamaño
    val animatedSize by animateDpAsState(
        targetValue = if (expanded) 145.dp else 95.dp,
        animationSpec = tween(durationMillis = 700),
        label = "SizeAnimation"
    )

    // Animación de la posición horizontal
    val animatedX by animateDpAsState(
        targetValue = if (expanded) 40.dp else 0.dp,
        animationSpec = tween(durationMillis = 700),
        label = "HorizontalPosition"
    )

    // Animación de la posición vertical
    val animatedY by animateDpAsState(
        targetValue = if (expanded) 25.dp else 0.dp,
        animationSpec = tween(durationMillis = 700),
        label = "VerticalPosition"
    )

    // Dos órdenes de modificadores para comparar
    val animatedBoxModifier = if (offsetFirst) {
        Modifier
            .offset(x = animatedX, y = animatedY)
            .padding(12.dp)
            .size(animatedSize)
    } else {
        Modifier
            .padding(12.dp)
            .offset(x = animatedX, y = animatedY)
            .size(animatedSize)
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

            Spacer(modifier = Modifier.height(34.dp))

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
                text = "Control del tamaño y la posición\nde elementos en pantalla.",
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 21.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Identificación
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
                        text = "03",
                        color = White,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "EJERCICIO 3",
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
                text = "Tamaño y posición",
                modifier = Modifier.fillMaxWidth(),
                color = Charcoal,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Utilización de animateDpAsState y Modifier.offset para transformar un elemento.",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Área de movimiento
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(24.dp))
                    .background(LightPlum)
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "VISTA DE TRANSFORMACIÓN",
                        color = Plum,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(205.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = animatedBoxModifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Burgundy),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "03",
                                color = White,
                                fontSize = 27.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = if (expanded) {
                            "TAMAÑO AMPLIADO · POSICIÓN MODIFICADA"
                        } else {
                            "TAMAÑO ORIGINAL · POSICIÓN INICIAL"
                        },
                        color = Plum,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.7.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Comparación del orden de modificadores
            Text(
                text = "ORDEN DE LOS MODIFICADORES",
                modifier = Modifier.fillMaxWidth(),
                color = Muted,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(9.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                Button(
                    onClick = { offsetFirst = true },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (offsetFirst) Burgundy else White,
                        contentColor = if (offsetFirst) White else Burgundy
                    )
                ) {
                    Text(
                        text = "OFFSET → PADDING",
                        fontSize = 9.sp
                    )
                }

                Button(
                    onClick = { offsetFirst = false },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!offsetFirst) Burgundy else White,
                        contentColor = if (!offsetFirst) White else Burgundy
                    )
                ) {
                    Text(
                        text = "PADDING → OFFSET",
                        fontSize = 9.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón principal
            Button(
                onClick = { expanded = !expanded },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Plum,
                    contentColor = White
                )
            ) {
                Text(
                    text = if (expanded) {
                        "RESTAURAR ELEMENTO"
                    } else {
                        "MOVER Y AMPLIAR"
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Autor permanente
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFD9CDD3))
            )

            Spacer(modifier = Modifier.height(13.dp))

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
fun SizePositionPreview() {
    Laboratorio13AnimacionesTheme {
        SizePositionScreen()
    }
}
