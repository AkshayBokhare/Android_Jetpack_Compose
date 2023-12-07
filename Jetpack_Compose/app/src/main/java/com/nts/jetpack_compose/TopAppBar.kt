package com.nts.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nts.jetpack_compose.ui.theme.Jetpack_ComposeTheme

class TopAppBar : ComponentActivity() {
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
                    topAppBarExample()
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBarExample() {

    val actiontext = remember {
        mutableStateOf("Action will be shown here..")
    }
    val menuStatus = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {

            androidx.compose.material3.TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        actiontext.value = "Navigation Icon Clicked"
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                title = {
                    Column {
                        Text(
                            text = stringResource(id = R.string.app_name), color = Color.White,
                            fontSize = 20.sp
                        )

                        Text(text = "SubTitle", color = Color.White, fontSize = 16.sp)
                    }
                },

                actions = {

                    IconButton(onClick = {
                        actiontext.value = "Share Icon Clicked"
                    }) {
                        Icon(Icons.Filled.Share, contentDescription = "Share")
                    }

                    IconButton(onClick = {
                        actiontext.value = "Search Icon Clicked"
                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }

                    IconButton(onClick = {
                        actiontext.value = "MoreVert Icon Clicked"
                        menuStatus.value= true
                    }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "MoreVert")

                      DropdownMenu(
                            expanded = menuStatus.value,
                            onDismissRequest = {
                                menuStatus.value= false
                            }) {
                            DropdownMenuItem(
                                text = { Text(text = "Setting") },
                                onClick = { menuStatus.value= false
                                actiontext.value="Setting Is Clicked"
                                })
                          DropdownMenuItem(
                              text = { Text(text = "Log Out") },
                              onClick = { menuStatus.value= false
                                  actiontext.value="Log Out Is Clicked"
                              })
                        }
                    }
                },

                colors = TopAppBarDefaults.smallTopAppBarColors(

                    containerColor = colorResource(id = R.color.purple_500),
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                    scrolledContainerColor = Color.White

                )

            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(text = actiontext.value, color = Color.Black, fontSize = 18.sp)
            }
        }
    )
}
