package com.ahrenswett.pillminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahrenswett.pillminder.classes.*
import com.ahrenswett.pillminder.ui.theme.PillMinderTheme
import java.util.*


var bottle = Bottle(
    consumable = Consumable(
        name = "Depakote",
        type = Type.MEDICATION,
        VolumePerUnit = 250F,
        form = Form.TABLET
    ),
    expirationDate = Date(2022,12,28),
    startDate = Date(2022,5,9),
    prescription = Prescription(
        volumeToTake = 3,
        prescribingDoc = "Chee M."
    ),
    quantityInBottle = 270,
    reminder = null
)

var bottleList : List<Bottle> = listOf(bottle)

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
                    Navagation()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PillMinderTheme {
        Navagation()
    }
}