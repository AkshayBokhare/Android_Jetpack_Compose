package com.nts.jetpack_list_lazygrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nts.jetpack_list_lazygrids.ui.theme.Jetpack_List_LazyGridsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_List_LazyGridsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavigation()
                }
            }
        }
    }
}


@Composable
fun MyNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "FirstPage"){
        composable("FirstPage"){
            FirstPage(navController = navController)
        }
        composable("SecondPage/{id}",
            arguments = listOf(
                navArgument("id"){type = NavType.IntType }
            )
        )
        {
            val countryId =it.arguments?.getInt("id")

            countryId?.let {id ->
                SecondPage(navController = navController, id =id )
            }



        }
    }
}