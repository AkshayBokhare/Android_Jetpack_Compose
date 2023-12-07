package com.nts.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

class DropdownMenu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    dropDown()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun dropDown() {

    val selectedItem = remember {
        mutableStateOf("INDIA")
    }
    val dropdownStatus = remember {
        mutableStateOf(false)
    }



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome To",
            color = Color.Blue,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Box {

            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    dropdownStatus.value = true
                }) {

                Box {

                }

                Text(text = selectedItem.value, modifier = Modifier.clickable {
                    dropdownStatus.value = true
                })
                Image(
                    painter = painterResource(id = R.drawable.drop_down_icon),
                    contentDescription = ""
                )
            }

            DropdownMenu(expanded = dropdownStatus.value, onDismissRequest = {
                dropdownStatus.value = false
            }) {

                DropdownMenuItem ( text = { Text(text = "INDIA") }  ,
                    onClick = {
                    dropdownStatus.value = false
                    selectedItem.value = "INDIA"
                }
                )


                DropdownMenuItem(text = {  Text(text ="JAPAN" )}, onClick = {
                    dropdownStatus.value = false
                    selectedItem.value = "JAPAN"
                })

                DropdownMenuItem(text = {  Text(text ="US" )}, onClick = {
                    dropdownStatus.value = false
                    selectedItem.value = "US"
                })
            }
        }


    }
}