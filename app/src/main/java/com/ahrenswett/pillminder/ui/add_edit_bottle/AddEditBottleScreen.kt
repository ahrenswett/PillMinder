package com.ahrenswett.pillminder.ui.add_edit_bottle

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetEvent
import com.ahrenswett.pillminder.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun AddEditBottleScreen(
    onPopBackStack: () -> Unit,
    viewModel : AddEditBottleViewModel = hiltViewModel(),
) {
    val focusRequester = remember { FocusRequester() }
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        focusRequester.requestFocus()
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }
    //TODO: Validate form so that all fields are filled out before allowing user to save.
    // or just navigate through questions and allow user to save when they are done.

    @Composable
    fun BottleBuilder(onDismiss: () -> Unit, radioOptions: List<String>, tabIndex: Int) {
        val context = LocalContext.current
        var consumableName by remember { mutableStateOf("") }

        Dialog(onDismissRequest = { onDismiss }) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(8.dp),
                elevation = 8.dp
            ) {
                //Variables for radio buttons that allow choice of supplement or medication
                val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[tabIndex]) }

                Column() {
                    Text(
                        text = "Which would you like to add?",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 20.sp
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        radioOptions.forEach { option ->
                            RadioButton(
                                selected = (option == selectedOption),
                                onClick = { onOptionSelected(option) },
                            )
                            Text(text = option.dropLast(1), fontSize = 15.sp,)
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
}