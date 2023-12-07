package com.nts.jetpack_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme
import kotlinx.coroutines.launch

class SnackBarMessage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                Surface ( modifier = Modifier
                    .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    snackBarMessage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun snackBarMessage(){

    val mySnackBarHostState = remember {
        SnackbarHostState()
    }
    val myCoroutineScope = rememberCoroutineScope()

    val myContex = LocalContext.current

    Scaffold (
        snackbarHost = {
            SnackbarHost(
                hostState = mySnackBarHostState
            ){
                Snackbar (
                    snackbarData = it
                    , containerColor = Color.Cyan
                    , contentColor = Color.Magenta
                    , actionColor = Color.Black
                    , dismissActionContentColor = Color.Red
                )

            }
        },
        content = { contentPadding ->
             Column (modifier = Modifier
                 .fillMaxSize()
                 .padding(contentPadding)
             , verticalArrangement = Arrangement.Center
             , horizontalAlignment = Alignment.CenterHorizontally)
             {

                    Button(onClick = {
                        myCoroutineScope.launch {

                            val result = mySnackBarHostState.showSnackbar(
                                message = "This is Snackbar Message"
                            ,actionLabel = "Show Toast"
                            , duration = SnackbarDuration.Indefinite
                            , withDismissAction = true)

                            if (result == SnackbarResult.ActionPerformed) {

                                Toast.makeText(myContex,"Action Perform",Toast.LENGTH_SHORT).show()
                            }
                        }

                    }) {
                        
                        Text(text = "Show SnackBar Message")
                    }

             }
        }
    )
}