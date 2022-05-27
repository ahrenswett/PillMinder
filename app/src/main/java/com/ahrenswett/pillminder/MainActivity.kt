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
import com.ahrenswett.pillminder.entities.*
import com.ahrenswett.pillminder.ui.theme.PillMinderTheme
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList


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
        dose = Dose(1000, Measurement.MILLIGRAMS),
        volumeToTake = 3,
        prescribingDoc = "Chee M."
    ),
    measurement = null,
    quantityInBottle = 270,
    reminder = Reminder(ArrayList(),Time(900))
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