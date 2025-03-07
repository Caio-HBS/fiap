package com.caiohbs.jurossimples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.caiohbs.jurossimples.juros.JurosScreen
import com.caiohbs.jurossimples.juros.JurosScreenViewModel
import com.caiohbs.jurossimples.ui.theme.JurosSimplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JurosSimplesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JurosScreen(JurosScreenViewModel())
                }
            }
        }
    }
}
