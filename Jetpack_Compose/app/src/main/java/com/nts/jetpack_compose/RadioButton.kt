package com.nts.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class RadioButton:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface ( modifier = Modifier
                    .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    radioButton()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun radioButton(){

    val myBackgroundColor= remember {
        mutableStateOf(Color.White)
    }
    val radioIndex= remember {
        mutableStateOf(0)
    }
    val radioTexts= listOf("Red","Green","Yellow","Magenta","DarkGray")
    val colorList= arrayListOf(Color.Red,Color.Green,Color.Yellow,Color.Magenta,Color.DarkGray,)

    Column(modifier = Modifier
        .fillMaxSize()
        .background(myBackgroundColor.value)
        , horizontalAlignment = Alignment.CenterHorizontally) {

        Column {

            Spacer(modifier = Modifier.size(40.dp))

            radioTexts.forEachIndexed { positon, name ->

                Row( verticalAlignment = Alignment.CenterVertically
                , modifier = Modifier.clickable {
                        radioIndex.value=positon
                     //   myBackgroundColor.value=colorList[radioIndex.value]
                    })
                {

                    RadioButton(
                        selected = name==radioTexts[radioIndex.value],
                        onClick = {
                            radioIndex.value=positon
                          //  myBackgroundColor.value=colorList[radioIndex.value]
                        },
                        colors = RadioButtonDefaults.colors(Color.Blue)
                    )
                    Text(text = name)
                }
            }

            Spacer(modifier = Modifier.size(40.dp))
        }

        Button(
                onClick = {
                    myBackgroundColor.value=colorList[radioIndex.value]
                }) {
                Text(text = "Change Background Color")

        }
    }
}