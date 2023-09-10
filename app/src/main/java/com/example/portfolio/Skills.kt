package com.example.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.Backgroundblue
import com.example.portfolio.ui.theme.PortFolioTheme

class Skills : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortFolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SkillsFun()
                }
            }
        }
    }
}
@Preview
@Composable
fun SkillsFun(){
    Surface(modifier = Modifier.fillMaxSize(), color = Backgroundblue) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("SKILLS", fontSize = 35.sp, color = Color.White,fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp))
            Text("Python\n" +
                    "\n" +
                    "Kotlin\n" +
                    "\n" +
                    "Xml\n" +
                    "\n" +
                    "Android Development\n" +
                    "\n" +
                    "Jetpack Compose\n" +
                    "\n" +
                    "Retrofit\n" +
                    "\n" +
                    "Firebase\n" +
                    "\n" +
                    "Api\n" +
                    "\n" +
                    "MySql", fontSize = 27.sp, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 15.dp))

        }

    }
}