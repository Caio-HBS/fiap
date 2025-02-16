package com.caiohbs.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caiohbs.layouts.ui.theme.LayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxScreen()
                }
            }
        }
    }
}

@Composable
fun BoxScreen() {
    Box(contentAlignment = Alignment.Center) {
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Text(text = "Clique aqui")
        }
        Text(
            text = "FIAP",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Button(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            Text(text = "Outro botão")
        }
    }
}
