package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.portfolio.ui.theme.Backgroundblue
import com.example.portfolio.ui.theme.ButtonColor
import com.example.portfolio.ui.theme.PortFolioTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortFolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageTwo()
                }
            }
        }

    }
}
@Preview
@Composable
fun PageTwo() {
    val context = LocalContext.current
    var imageUrl by remember { mutableStateOf("") }
    val mContext = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize(), color = Backgroundblue) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "banner",
                modifier = Modifier
                    .height(283.dp)
                    .fillMaxWidth()
                    .padding(10.dp),
                contentScale = ContentScale.FillBounds,
            )
            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, Skills::class.java))
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(250.dp)
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
            ) {
                Text(text = "SKILLS", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)

            }
            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, Education::class.java))
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(250.dp)
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
            ) {
                Text(text = "EDUCATION", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)

            }
            Button(
                onClick = {
                    mContext.startActivity(Intent(mContext, Work::class.java))
                },
                modifier = Modifier
                    .height(70.dp)
                    .width(250.dp)
                    .padding(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
            ) {
                Text(text = "WORK", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)

            }
            Text(
                "Socials:", fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 30.dp, bottom = 10.dp)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "linkedin",
                    modifier = Modifier.size(40.dp).clickable {
                        imageUrl = "https://www.linkedin.com/in/sabir-khan-363a271ba"

                    }
                )

                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "Instagram",
                    modifier = Modifier.size(40.dp).clickable {
                        imageUrl = "https://instagram.com/com.insta.sabir?igshid=MzNlNGNkZWQ4Mg=="
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "Github",
                    modifier = Modifier.size(40.dp).clickable {
                        imageUrl = "https://www.github.com/DroidMystic"
                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.telegram),
                    contentDescription = "Telegram",
                    modifier = Modifier.size(40.dp).clickable {
                        imageUrl = "https://www.t.me/DroidMystic"
                    }
                )
                if (imageUrl.isNotEmpty()) {
                    LaunchedEffect(imageUrl) {
                        val uri = Uri.parse(imageUrl)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}











