package com.ahrenswett.pillminder.ui.add_edit_cabinet

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.util.UiEvent
import kotlinx.coroutines.flow.collect
//  https://stackoverflow.com/questions/67396976/use-dialog-as-navigation-destination-with-jetpack-compose

@Composable
fun AddEditCabinetScreen(
    onPopBackStack: () -> Unit,
    viewModel: AddEditCabinetViewModel = hiltViewModel()
) {
    //Creates auto focus on Cabinet Name text field
    val focusRequester = remember { FocusRequester() }
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        focusRequester.requestFocus()
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    Dialog(onPopBackStack) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(10.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp, 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = viewModel.name,
                    onValueChange = {
                        viewModel.onEvent(AddEditCabinetEvent.onNameChange(it))
                    },
                    // Responsible for submitting the cabinet name from the keyboard
                    keyboardActions = KeyboardActions(onDone = {
                        viewModel.onEvent(AddEditCabinetEvent.onSubmit).also {
                            Log.i("Executed", "Keyboard Action")
                        }
                    }),
                    // Ensures that there is no return feature on the Keyboard replaces with a checkmark.
                    placeholder = {
                        if (viewModel.cabinet != null) Text(text = viewModel.cabinet!!.name)
                        else Text(text = "Cabinet Name")
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester).padding(8.dp),
                )
                Row {
                    OutlinedButton(
                        onClick = onPopBackStack,
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = {
                            Toast.makeText(context, viewModel.name, Toast.LENGTH_SHORT).show()
                            viewModel.onEvent(AddEditCabinetEvent.onSubmit)},
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