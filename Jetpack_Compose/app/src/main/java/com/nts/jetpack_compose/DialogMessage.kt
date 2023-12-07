package com.nts.jetpack_compose

import android.app.AlertDialog
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class DialogMessage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {

                    dialogMessage()

                }
            }
        }
    }
}

@Composable
fun dialogMessage() {

    val mydialogStatus = remember {
        mutableStateOf(false)
    }
    val textColor = remember {
        mutableStateOf(Color.White)
    }

    val mycontex = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { mydialogStatus.value = true }) {

            Text(text = "Show Dialog Measssage", color = textColor.value)

        }

        if (mydialogStatus.value) {

            AlertDialog(onDismissRequest = { mydialogStatus.value = true },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.warning),
                        modifier = Modifier.size(50.dp, 50.dp),
                        contentDescription = ""
                    )
                },
                title = { Text(text = "Dialog meassage", color = Color.Black, fontSize = 20.sp) },
                text = {
                    Text(
                        text = "Do You Want To Change Button Text ?",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                },
                containerColor = Color.DarkGray,
                shape = RoundedCornerShape(10.dp),

                confirmButton = {
                    Button(
                        onClick = {

                            mydialogStatus.value = false
                            textColor.value = Color.Yellow
                            Toast.makeText(mycontex, "Confurm button cliekd", Toast.LENGTH_SHORT)
                                .show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(text = "Yes", color = Color.Yellow, fontSize = 18.sp)
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {

                            mydialogStatus.value = false

                            Toast.makeText(mycontex, "Dismis button cliekd", Toast.LENGTH_SHORT)
                                .show()

                        },

                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier.width(100.dp)


                    ) {
                        Text(text = "No", color = Color.Cyan, fontSize = 18.sp)
                    }
                })
        }
    }


}




