package com.ahrenswett.pillminder.util

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.navArgument
import com.ahrenswett.pillminder.Navigation
import com.ahrenswett.pillminder.ui.add_edit_bottle.AddEditBottleEvent
import com.ahrenswett.pillminder.ui.add_edit_bottle.AddEditBottleScreen
import com.ahrenswett.pillminder.ui.add_edit_bottle.AddEditBottleViewModel
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetEvent

val questionsList = listOf(
    "Which would you like to add?",
    "What form is the",

)


//  Create a temp bottle to hold bottle info before passing to VM bottle? This may help with editing






/********************************* Composable to get Name of and whether or not it is medication or Supplement *********************************/
@Composable
fun BottleBuilder(onDismiss: () -> Unit, tabIndex: Int, viewModel: AddEditBottleViewModel) {
    val consumableTypesList = listOf("Medication","Supplement")
    val context = LocalContext.current
    val focusRequester = remember { FocusRequester() }


    Dialog( onDismissRequest = { onDismiss() }) {
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
                    value = viewModel.name,
                    onValueChange = {
                        viewModel.onEvent(AddEditBottleEvent.OnNameChange(it))
                    },
                    keyboardActions = KeyboardActions(onDone = {
                        onDismiss()
                    }),
                    singleLine = true,
                    modifier = Modifier
                        .padding(8.dp)
                        .focusRequester(focusRequester),
//                    label = { Text(text = "Enter the $selectedOption name") }
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
//                            viewModel.onEvent(AddEditBottleEvent.OnNameChange())
                            Toast.makeText(context, viewModel.name, Toast.LENGTH_SHORT).show()
                            onDismiss()
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