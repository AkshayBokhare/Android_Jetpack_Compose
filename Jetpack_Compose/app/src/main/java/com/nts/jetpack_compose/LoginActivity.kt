package com.nts.jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme


class LoginActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface(color = MaterialTheme.colorScheme.primary)
                {
                    //buttons()
                    // LoginScreen()

                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginScreen() {
        val username = remember { mutableStateOf(" ") }
        val userpassword = remember { mutableStateOf(" ") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
            //, verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Hello",
                color = Color.Blue,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Welcome",

                color = Color.Blue,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Back..!", color = Color.Blue, fontSize = 20.sp, fontWeight = FontWeight.Bold
            )

            OutlinedTextField(value = username.value, onValueChange = {
                username.value = it
            }, leadingIcon = {
                Icon(Icons.Filled.Person, contentDescription = "Person")
            }, label = {
                Text(text = "UserName")
            }, placeholder = {
                Text(text = "Enter User Name")
            }, modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(value = userpassword.value, onValueChange = {
                userpassword.value = it
            }, leadingIcon = {
                Icon(Icons.Filled.Info, contentDescription = "password")
            }, label = {
                Text(text = "userPassword", color = Color.DarkGray)
            },
                placeholder = {
                    Text(text = "Enter User's Password", color = Color.DarkGray)
                }, modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(onClick = {
                loginDetails(username.value, userpassword.value)
            }, modifier = Modifier.fillMaxWidth()) {

                Text(text = "Login")

            }

        }
    }

    private fun loginDetails(username: String, userpassword: String) {
        if (username == "akshay" && userpassword == "12345") {
            Toast.makeText(this, "User Login", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun buttons() {

    var myButtonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }
    var myButtonText = remember {
        mutableStateOf("Do your Magic")
    }
    var myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }
    var valueonTextfield = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Image(
            painter = painterResource(id = R.drawable.squirrel),
            contentDescription = "First_Image",
            alignment = Alignment.Center
        )

        Spacer(modifier = Modifier.size(20.dp))
        
        Button(
            onClick = {
                myButtonBackgroundColor.value = Color.Blue
                myButtonText.value = "Compose is Fun"
                myButtonTextColor.value = Color.Yellow
            }, modifier = Modifier.size(250.dp, 50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myButtonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    Spacer(modifier = Modifier.size(20.dp))

    TextField(
        value = valueonTextfield.value,
        onValueChange = {
            valueonTextfield.value = it
        },
        label = { Text(text = "Enter your name") },
        colors = TextFieldDefaults.outlinedTextFieldColors(

            containerColor = Color.Cyan,
        ),

//    //        open keybord in specific format
//      keyboardOptions =KeyboardOptions(keyboardType = KeyboardType.Phone),
//    //TextField Visual Transformation like hide
//        visualTransformation = PasswordVisualTransformation()
    )

}


