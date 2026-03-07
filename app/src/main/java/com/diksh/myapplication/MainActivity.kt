package com.diksh.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diksh.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoginPage()

//                    ContactInfo()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun LoginPage(){

        val context = LocalContext.current
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier.fillMaxSize().padding(30.dp),
                contentAlignment = Alignment.TopCenter,
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        "AppLogo",
                        modifier = Modifier.size(100.dp).padding(bottom = 10.dp)
                    )

                    Text("Welcome to The To Do App !", modifier = Modifier.padding(bottom = 10.dp))

                    TextField(value = email,
                        onValueChange = {email = it},
                        modifier = Modifier.padding(bottom = 10.dp), 
                        label = {Text("Email")}
                    )

                    TextField(value = password, onValueChange = {password = it},
                        modifier = Modifier.padding(10.dp),
                        label = {Text("Password")})


                    Button(onClick = {
                        Toast.makeText(context,"Submit clicked and entered Email is $email & password is $password", Toast.LENGTH_SHORT).show()
                    },
                        modifier = Modifier.padding(bottom = 10.dp)) { Text("Submit")}
                }
            }
        }
    }

    @Composable
    fun CircularPhoto(imageResource: Int, contentDescription: String?, modifier: Modifier = Modifier) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop, // Fill the shape
            modifier = modifier
                .size(100.dp) // Define diameter
                .clip(CircleShape) // Clip to circle
                .border(2.dp, Color.Gray, CircleShape)
        )
    }

//    @Preview(showBackground = true)
    @Composable
    fun ContactInfo() {
        val context = LocalContext.current

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
            ) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        CircularPhoto(
                            R.drawable.ic_launcher_background,
                            "Profile",
                            modifier = Modifier.padding(bottom = 20.dp)
                        )

                        Text(
                            text = "Diksh",
                            fontSize = 20.sp
                        )

                        Text(
                            text = "Engineer",
                            fontSize = 16.sp
                        )

                        Button(onClick = {
                            Log.d("button clicked", "Button clikced")
                            Toast.makeText(
                                context,
                                "Followed Diksh",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                            Text("Follow")
                        }
                    }

            }
        }
    }
}
