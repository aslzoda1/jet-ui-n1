package com.example.jet_ui_n1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

 val AboutTitleFont = FontFamily(Font(R.font.holly))
val AboutBodyFont = FontFamily(Font(R.font.superr))

 class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AboutScreen(onBack = { finish() })
            }
        }
    }
}

@Composable
fun AboutScreen(onBack: () -> Unit) {

    val scrollState = rememberScrollState()

     val backgroundBrush = remember {
        Brush.verticalGradient(
            listOf(
                Color(0xFF008EFF).copy(alpha = 0.35f),
                Color(0xFFE2EAFA),
                Color.White
            )
        )
    }

     val backBrush = remember {
        Brush.linearGradient(
            listOf(
                Color.White.copy(alpha = 0.4f),
                Color.White.copy(alpha = 0.15f)
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundBrush)
    ) {

         Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 50.dp, start = 20.dp)
                .size(50.dp)
                .clip(CircleShape)
                .background(backBrush)
                .clickable { onBack() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier.size(24.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            Spacer(modifier = Modifier.height(120.dp))

             Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(150.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 🔹 Glass Card (lighter shadow)
            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(30.dp),
                elevation = CardDefaults.cardElevation(6.dp), // 8 → 6
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.85f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(28.dp)
                ) {

                    Text(
                        text = "About Application",
                        fontSize = 22.sp,
                        fontFamily = AboutTitleFont,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = """
Android Cafe is a modern Android UI demo application built with Jetpack Compose.

This app demonstrates:
• Collapsing header
• Parallax effects
• Smooth animations
• Material 3 design system

Developer: Aslzoda Bozorboyeva
Version: 1.0
                        """.trimIndent(),
                        fontSize = 16.sp,
                        fontFamily = AboutBodyFont,
                        lineHeight = 26.sp,
                        color = Color(0xFF333333)
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

             Image(
                painter = painterResource(id = R.drawable.android_cafe_dessert),
                contentDescription = "Dessert",
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .height(220.dp)
                    .shadow(6.dp, RoundedCornerShape(28.dp)), // 8 → 6
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp"
)
@Composable
fun AboutScreenPreview() {
    MaterialTheme {
        AboutScreen(onBack = {})
    }
}