package com.ahrenswett.pillminder

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahrenswett.pillminder.classes.*
import com.ahrenswett.pillminder.ui.theme.PillMinderTheme
import com.ahrenswett.pillminder.ui.composables.MenuCard
import java.util.*

val bottle = Bottle(consumable = Consumable(
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
    quantityInBottle = 270
)

val bottleList : List<Bottle> = emptyList()

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
                    Hoist()
                }
            }
        }
    }
}

@Composable
fun MainApp(){
//    if()
}




@Composable
fun AddConsumable (){

}




enum class HoistState{
    GREETING,
    ADD_CONSUMABLE,
    LIST
}

@Composable
fun Hoist() {
    var state by remember{mutableStateOf (HoistState.GREETING)}
    if(state == HoistState.LIST)ShowConsumableList()
    if(state == HoistState.ADD_CONSUMABLE) AddConsumable()
    else Greeting(bottleList,state)
}



@Composable
fun Greeting(bottleList: List<Bottle>, hoistState: HoistState) {
    var context = LocalContext.current
    var showAlert by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize(),Arrangement.SpaceEvenly ) {
        Card(Modifier
                .wrapContentSize()
                .fillMaxWidth().height(intrinsicSize = IntrinsicSize.Max)
                .clickable {
                    if (bottleList.isEmpty()) {
                        showAlert = !showAlert
                        Toast
                            .makeText(context, showAlert.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }){
            Text(text = "View your medications and supplements",
                modifier = Modifier.fillMaxWidth().height(intrinsicSize = IntrinsicSize.Max),
                textAlign = TextAlign.Center)
        }

        Divider()

        Row( Modifier.fillMaxWidth(),Arrangement.SpaceEvenly) {
            Text(text = "Add Medication or Supplement Reminder")
        }
    }

//    List was empty ALERT!!!
    if(showAlert) AlertDialog(
        onDismissRequest = { showAlert = false },
        title = {Text( "No medications or supplements to show")},
        text =  { Text("Please add an item")},
        confirmButton = {
            Button(onClick = { showAlert = false }) {
                Text("Dismiss")
            }
        });
}







@Composable
fun ShowConsumableList(){
    val consumable = bottle.consumable
    val type = consumable.type.name.lowercase().replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault())
        else it.toString() }
    val form = consumable.form.name.lowercase().replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault())
        else it.toString() }
    Column() {
        Text(text = "$type Alert")
        Text(text = consumable.name)
        Text(text = "Form: $form")
        Text(text = "Take ${bottle.prescription?.volumeToTake} by mouth every 24 hours")

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PillMinderTheme {
        Hoist()
    }
}