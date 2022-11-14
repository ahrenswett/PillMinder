package com.ahrenswett.pillminder.util

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

//var showCustomDialog by remember {
//    mutableStateOf(false)
//}
//if (showCustomDialog) {
//    BottleBuilder({
//        showCustomDialog = !showCustomDialog
/********************************* Composable to get Name of and whether or not it is medication or Supplement *********************************/
@Composable
fun BottleBuilder(onDismiss: () -> Unit, tabIndex: Int) {
    val context = LocalContext.current
    var consumableName by remember { mutableStateOf("") }
    val consumableTypesList = listOf("Medication","Supplement")

    Dialog(onDismissRequest = { onDismiss }) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
        ) {
            //Variables for radio buttons that allow choice of supplement or medication
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(consumableTypesList[tabIndex]) }

            Column() {
                Text(
                    text = "Which would you like to add?",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 20.sp
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    consumableTypesList.forEach { option ->
                        RadioButton(
                            selected = (option == selectedOption),
                            onClick = { onOptionSelected(option) },
                        )
                        Text(text = option, fontSize = 15.sp,)
                    }
                }
                OutlinedTextField(
                    value = consumableName,
                    onValueChange = { consumableName = it },
                    modifier = Modifier.padding(8.dp),
                    keyboardActions = KeyboardActions(onDone = {
                        Toast.makeText(context, consumableName, Toast.LENGTH_SHORT).show()
                        onDismiss()
                    }),
                    singleLine = true,
                    label = { Text(text = "Enter a name") }
                )
                Row {
                    //Cancel Button
                    OutlinedButton(
                        onClick = { onDismiss() },
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Cancel")
                    }
                    //Submit Button
                    Button(
                        onClick = {
                            Toast.makeText(context, consumableName, Toast.LENGTH_SHORT).show()
                            onDismiss()
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    }
}




/********************************* Composable to get Form of medication or Supplement *********************************/
@Composable
fun WhatFormIsIt(){
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Dialog(onDismissRequest = {}) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
        ) {
            Column() {
                Text(text = "What form is the _ in?")
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = !expanded }) {

                }
                Row {
                    OutlinedButton(
                        onClick = { },
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = {
                            Toast.makeText(context, "consumableName", Toast.LENGTH_SHORT).show()
                             },

                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Next")
                    }
                }

            }

        }
    }

}