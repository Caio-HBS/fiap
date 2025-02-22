package com.caiohbs.navegando

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.caiohbs.navegando.screens.LoginScreen
import com.caiohbs.navegando.screens.MenuScreen
import com.caiohbs.navegando.screens.PedidosScreen
import com.caiohbs.navegando.screens.PerfilScreen
import com.caiohbs.navegando.ui.theme.NavegandoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegandoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController) }
                        composable(route = "pedidos") { PedidosScreen(navController) }
                        composable(route = "perfil") { PerfilScreen(navController) }
                    }
                }
            }
        }
    }
}
