package com.example.portfolio

import android.content.Intent
import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolio.ui.theme.Backgroundblue
import com.example.portfolio.ui.theme.ButtonColor
import com.example.portfolio.ui.theme.CardBackground
import com.example.portfolio.ui.theme.PortFolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortFolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Portfolio()
                }
            }
        }
    }
}
@Preview
@Composable
fun Portfolio(){
    val mContext = LocalContext.current
    LazyColumn() {
        item {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Backgroundblue
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    CreateImageProfile()
                    CreateInfo()
                    CreateCard()
                    Button(onClick ={
                        mContext.startActivity(Intent(mContext, SecondActivity::class.java))
                    }, colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)) {
                        Text(text = "Learn More...", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)

                    }

                }

            }
        }
    }

}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.size(160.dp),
        shape = CircleShape,
        border = BorderStroke(1.0.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pfp),
            contentDescription = "profile image",
            modifier = modifier.size(160.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text("Sabir Khan", fontSize = 35.sp, color = Color.White,fontWeight = FontWeight.Bold)
        Text("Android Developer", fontSize = 17.sp, color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 13.dp))

    }
}
@Preview
@Composable
private fun CreateCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(560.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground)
    ) {
        LazyColumn {
            item {
                Text(
                    "Hi there! I'm Sabir Khan, a passionate tech enthusiast with a deep love for coding and a particular affinity for Android development. My journey in the world of technology began when I was fascinated by the endless possibilities that coding offered. Since then, I've been on an exciting and never-ending quest to explore the vast realms of the digital world.\n" +
                            "\n" +
                            "As a dedicated Android developer, I thrive on the challenge of crafting elegant, user-friendly, and efficient mobile applications. Android, with its open-source nature and massive user base, has become my canvas for creating innovative and impactful solutions. From designing sleek user interfaces to diving into the intricacies of Kotlin, I'm constantly pushing my boundaries to deliver top-notch Android experiences.\n" +
                            "\n" +
                            "When I'm not buried in code, you can find me discussing tech trends, attending hackathons, or engaging in stimulating conversations about the future of mobile technology. I'm a firm believer in the idea that technology has the potential to shape the world for the better, and I'm excited to be a part of that transformation.",
                    modifier = Modifier.padding(5.dp),
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
            }

        }
    }
}
