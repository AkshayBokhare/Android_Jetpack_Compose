package com.nts.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme


class SwitchExample: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface ( modifier = Modifier
                    .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    switch()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun switch(){

    val switchState= remember {
        mutableStateOf(false)
    }
    val myText= remember {
        mutableStateOf("The Image is Visible")
    }
    val selectedItem= remember {
        mutableStateOf("India")
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
            Spacer(modifier = Modifier.size(50.dp))

        Switch(
            checked =switchState.value,
            onCheckedChange ={
                switchState.value=it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color.DarkGray,
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.DarkGray
            ))

        Spacer(modifier = Modifier.size(30.dp))

        if (!switchState.value){

            Image(painter = painterResource(id = R.drawable.panda),
                contentDescription = "panda", modifier = Modifier.size(300.dp)
                , contentScale = ContentScale.Fit
                , alignment = Alignment.Center
            )

            myText.value = "The Image is Visible"

        }else{
            Spacer(modifier =Modifier.size(300.dp))
            myText.value="The Image is InVisible"
        }

        Spacer(modifier = Modifier.size(30.dp))

        Text(text = myText.value,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue)
                .width(300.dp)
                .padding(top = 10.dp, bottom = 10.dp)
        )

    }
}