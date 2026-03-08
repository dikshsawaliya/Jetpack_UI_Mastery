package com.diksh.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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

                    InstagramPage()
//                    LoginPage()

//                    ContactInfo()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun InstagramPage(){

        var selectedGrid by remember { mutableStateOf(0) }

        Box(modifier = Modifier.fillMaxSize()){

            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {

                    Image(
                        painter = painterResource(R.drawable.outline_add_24),
                        contentDescription = "Plus Icon",
                        modifier = Modifier
                            .size(30.dp)
                            .weight(1f)
                    )

                    Box(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.outline_adb_24),
                                contentDescription = "Plus Icon",
                                modifier = Modifier.size(30.dp)
                            )

                            Text("diksh_sawaliya")
                        }
                    }

                    Button(
                        onClick = {},
                        colors = ButtonColors(
                            Color.Transparent,
                            contentColor = Color.Black,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.Transparent,
                        ),
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.outline_chat_info_24),
                            contentDescription = null,
                            modifier = Modifier.background(
                                Color.Transparent,
                                shape = CircleShape
                            )
                        )
                    }
                }

                Row(modifier = Modifier.padding(top = 40.dp)) {
                    CircularPhoto(
                        R.drawable.ic_launcher_background,
                        contentDescription = "Profile",
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column() {
                            Text("Diksh Sawaliya", modifier = Modifier.padding(start = 30.dp))

                            Row(modifier = Modifier.padding(top = 20.dp)) {
                                Column() {
                                    Text("36", modifier = Modifier.padding(start = 30.dp))
                                    Text("Posts", modifier = Modifier.padding(start = 30.dp))
                                }

                                Column() {
                                    Text("3600", modifier = Modifier.padding(start = 30.dp))
                                    Text("Follower", modifier = Modifier.padding(start = 30.dp))
                                }

                                Column() {
                                    Text("450", modifier = Modifier.padding(start = 30.dp))
                                    Text("Following", modifier = Modifier.padding(start = 30.dp))
                                }
                            }
                        }
                    }
                }

                Row(modifier = Modifier.padding(20.dp)) {

                    Button(onClick = {}, modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)) {
                        Text("Edit Profile")
                    }

                    Button(onClick = {}, modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)) {
                        Text("Share Profile")
                    }
                }


                ScrollableRow()

                GridButtons(onGridSelected = { selectedGrid = it })
                    when (selectedGrid) {
                        0 -> GridPhotos()
                        1 -> GridPhotos1()
                        2 -> GridPhotos3()
                        else -> GridPhotos() // Default to first if needed
                    }
            }
        }
    }


    @Composable
    fun ScrollableRow(){
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            repeat(15){
                Card(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = it.toString(),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )
                }
            }

        }
    }


    @Composable
    fun GridPhotos(){
        repeat(3) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(3) {
                            CircularPhoto(
                                R.drawable.ic_launcher_background,
                                contentDescription = "Profile",
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }

            }
        }
    }

    @Composable
    fun GridPhotos1(){
        repeat(3) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(3) {
                        CircularPhoto(
                            R.drawable.outline_adb_24,
                            contentDescription = "Profile",
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }

            }
        }
    }

    @Composable
    fun GridPhotos3(){
        repeat(3) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(3) {
                        CircularPhoto(
                            R.drawable.outline_add_24,
                            contentDescription = "Profile",
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }

            }
        }
    }


    @Composable
    fun GridButtons(onGridSelected: (Int) -> Unit){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Button(
                    onClick = { onGridSelected(0) },
                    colors = ButtonColors(
                        Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.outline_chat_info_24),
                        contentDescription = null,
                        modifier = Modifier.background(
                            Color.Transparent,
                            shape = CircleShape
                        )
                    )
                }

                Button(
                    onClick = { onGridSelected(1) },
                    colors = ButtonColors(
                        Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.outline_chat_info_24),
                        contentDescription = null,
                        modifier = Modifier.background(
                            Color.Transparent,
                            shape = CircleShape
                        )
                    )
                }

                Button(
                    onClick = { onGridSelected(2) },
                    colors = ButtonColors(
                        Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.outline_chat_info_24),
                        contentDescription = null,
                        modifier = Modifier.background(
                            Color.Transparent,
                            shape = CircleShape
                        )
                    )
                }

                Button(
                    onClick = { onGridSelected(3) },
                    colors = ButtonColors(
                        Color.Transparent,
                        contentColor = Color.Black,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.outline_chat_info_24),
                        contentDescription = null,
                        modifier = Modifier.background(
                            Color.Transparent,
                            shape = CircleShape
                        )
                    )
                }
            }
        }
    }
    @Composable
    fun LoginPage(){

        val context = LocalContext.current
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                contentAlignment = Alignment.TopCenter,
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        "AppLogo",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 10.dp)
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
