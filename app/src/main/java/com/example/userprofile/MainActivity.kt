package com.example.userprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfileScreen()
        }
    }
}

@Composable
fun UserProfileScreen() {
    var showSnackbar by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Centers the content vertically
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center, // Centers the content vertically
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Image
                Image(
                    painter = painterResource(id = R.drawable.profile), // Replace with actual image
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Username
                Text(
                    text = "Billy Brown",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Bio
                Text(
                    text = "UI/UX Designer | Creative | Athlete ",
                    fontSize = 18.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Follow Button
                Button(
                    onClick = { showSnackbar = true },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(text = "Follow", fontSize = 18.sp)
                }
            }
        }

        // Snackbar appears when the Follow button is clicked
        if (showSnackbar) {
            Snackbar(
                action = {
                    TextButton(onClick = { showSnackbar = false }) {
                        Text("Dismiss", color = Color.White)
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Following")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreviewProfile() {
    UserProfileScreen()
}



