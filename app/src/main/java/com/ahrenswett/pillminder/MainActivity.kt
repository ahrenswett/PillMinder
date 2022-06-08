package com.ahrenswett.pillminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ahrenswett.pillminder.data.AppDatabase
import com.ahrenswett.pillminder.ui.theme.PillMinderTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
            PillMinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Navigation()
                }
            }
        }
        val dao = AppDatabase.getDatabase(this).cabinetDAO
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PillMinderTheme {
        Navigation()
    }
}