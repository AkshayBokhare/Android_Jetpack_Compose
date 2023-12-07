package com.nts.navigation_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nts.navigation_compose.ui.theme.Navigation_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavigations()
                }
            }
        }
    }
}

@Composable
fun MyNavigations(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainPage") {

        composable(route = "MainPage") {
            MainPage(navController)
        }
        composable(
            route = "SecondPage /{name}/{age}",
            arguments = listOf(
                navArgument("name"){type = NavType.StringType },
                navArgument("age"){type = NavType.IntType }
            )
        ) {navBackStackEntry ->

           val name = navBackStackEntry.arguments?.getString("name")
           val age = navBackStackEntry.arguments?.getInt("age")

            name?.let {userName->
                age?.let {userAge->

                    SecondPage(navController,userName,userAge)
                }
            }
        }
    }
}