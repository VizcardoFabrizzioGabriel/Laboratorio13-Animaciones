
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
import androidx.compose.foundation.border
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
private val DeepBurgundy = Color(0xFF642238)
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 26.dp, vertical = 22.dp),
        horizontalAlignment = Alignment.Start
    ) {

        // HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ÉLAN",
                color = Burgundy,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 5.sp
            )

            Text(
                text = "MOTION SERIES  /  01",
                color = Muted,
                fontSize = 9.sp,
                letterSpacing = 1.5.sp
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        // TITLE
        Text(
            text = "The art of",
            color = Charcoal,
            fontSize = 35.sp,
            fontWeight = FontWeight.Light
        )

        Text(
            text = "being present.",
            color = Burgundy,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Una experiencia de movimiento y elegancia.",
            color = Muted,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        // DECORATIVE DIVIDER
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(Color(0xFFD8CDD0))
            )

            Text(
                text = "01",
                color = Burgundy,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 14.dp)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(Color(0xFFD8CDD0))
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ANIMATION CARD
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(26.dp),
            color = White,
            shadowElevation = 3.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "VISUAL EXPERIENCE",
                        color = Muted,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )

                    Box(
                        modifier = Modifier
                            .size(9.dp)
                            .clip(CircleShape)
                            .background(
                                if (visible) Burgundy else Plum
                            )
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // ANIMATION AREA
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFF2ECF0)),
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
                                    .padding(horizontal = 16.dp)
                                    .clip(RoundedCornerShape(22.dp))
                                    .background(Burgundy)
                                    .padding(
                                        horizontal = 20.dp,
                                        vertical = 28.dp
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                // DECORATIVE CIRCLE
                                Box(
                                    modifier = Modifier
                                        .size(72.dp)
                                        .clip(CircleShape)
                                        .background(White.copy(alpha = 0.13f))
                                        .border(
                                            width = 1.dp,
                                            color = White.copy(alpha = 0.35f),
                                            shape = CircleShape
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "É",
                                        color = White,
                                        fontSize = 39.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = "A moment of elegance",
                                    color = White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.Center
                                )

                                Spacer(modifier = Modifier.height(9.dp))

                                Text(
                                    text = "Every detail finds its place.",
                                    color = White.copy(alpha = 0.75f),
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )

                                Spacer(modifier = Modifier.height(20.dp))

                                Box(
                                    modifier = Modifier
                                        .width(35.dp)
                                        .height(2.dp)
                                        .background(White.copy(alpha = 0.7f))
                                )
                            }
                        }

                        if (!visible) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "01",
                                    color = Plum,
                                    fontSize = 52.sp,
                                    fontWeight = FontWeight.Light
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "A space for something beautiful",
                                    color = Muted,
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // STATE INFORMATION
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "ELEMENT STATE",
                        color = Muted,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )

                    Text(
                        text = if (visible) "VISIBLE" else "HIDDEN",
                        color = if (visible) Burgundy else Plum,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // INTERACTION BUTTON
                Button(
                    onClick = {
                        visible = !visible
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (visible) Plum else Burgundy
                    )
                ) {
                    Text(
                        text = if (visible)
                            "HIDE EXPERIENCE"
                        else
                            "REVEAL EXPERIENCE",
                        color = White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // FOOTER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "JETPACK COMPOSE",
                color = Muted,
                fontSize = 9.sp,
                letterSpacing = 1.5.sp
            )

            Text(
                text = "ANIMATION STUDY",
                color = Burgundy,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "ÉLAN - Minimalist Motion"
)
@Composable
fun ElanPreview() {
    Laboratorio13AnimacionesTheme {
        ElanScreen()
    }
}
