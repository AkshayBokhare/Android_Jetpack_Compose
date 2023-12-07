package com.nts.jetpack_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class CheckBox : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    myCheckBox()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun myCheckBox() {

    val resultText = remember {
        mutableStateOf("What is your Gender ?")
    }
    val firstCheckbox = remember {
        mutableStateOf(false)
    }
    val secondCheckbox = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0476D0)),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.size(150.dp))

        Text(
            text = resultText.value,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .width(300.dp)
                .background(Color(0xFFF44336))
                .padding(top = 15.dp, bottom = 15.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(50.dp))

        Column {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = firstCheckbox.value,
                    onCheckedChange = {
                        firstCheckbox.value = it
                        if (firstCheckbox.value){
                            resultText.value ="Your Gender is Male"
                            secondCheckbox.value=false
                        }else{
                            resultText.value ="What is your Gender"
                        }
                    },
                    colors = CheckboxDefaults.colors(Color(0xFFF44336))
                )
                Text(text = "Male", fontSize = 20.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.size(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = secondCheckbox.value,
                    onCheckedChange = {
                        secondCheckbox.value = it
                        if (secondCheckbox.value){
                            resultText.value ="Your Gender is FeMale"
                            firstCheckbox.value=false
                        }else{
                            resultText.value ="What is your Gender"
                        }
                    },
                    colors = CheckboxDefaults.colors(Color(0xFFF44336))
                )
                Text(text = "Female", fontSize = 20.sp, color = Color.White)
            }

        }
    }
}