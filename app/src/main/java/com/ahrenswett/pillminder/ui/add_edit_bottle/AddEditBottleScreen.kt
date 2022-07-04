package com.ahrenswett.pillminder.ui.add_edit_bottle

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
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

    LaunchedEffect(key1 = true){
        focusRequester.requestFocus()
        viewModel.uiEvent.collect{ event ->
            when(event){
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }
    //TODO: Validate form so that all fields are filled out before allowing user to save.
    // or just navigate through questions and allow user to save when they are done.

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {

//    ***********  Bottle Name Text Field *************
            OutlinedTextField(
                value = viewModel.name,
                onValueChange = {
                    viewModel.onEvent(AddEditBottleEvent.OnNameChange(it))
                },
                singleLine = true,
                placeholder = {
                    if (viewModel.name.isEmpty()) Text("Name")
                    else Text(viewModel.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                label = { Text("Contents Name") }
            )

            Spacer(modifier = Modifier.height(16.dp))

//    ***********  Bottle Quanitity Text Field *************
            OutlinedTextField(
                value = viewModel.quantity.toString(),
                onValueChange = {
                    viewModel.onEvent(AddEditBottleEvent.OnQuantityChange(it.toInt()))
                },
                singleLine = true,
                placeholder = {
                    if (viewModel.quantity == 0) Text("Enter Quantity")
                    else Text(viewModel.quantity.toString())
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("Quantity in Bottle") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                //TODO: Measurement starts at end of float does not overwrite existing zeros :(
                value = viewModel.mesurementPerUnit.toString(),
                onValueChange = {
                    viewModel.onEvent(AddEditBottleEvent.OnMeasurementChange(it.toFloat()))
                },
                keyboardActions = KeyboardActions(  onDone = {viewModel.onEvent(AddEditBottleEvent.OnSubmit)}),
                singleLine = true,
                placeholder = {
                    if (viewModel.mesurementPerUnit == 0F) Text("Enter a Measurement Amount")
                    else Text(viewModel.mesurementPerUnit.toString())
                },
                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text("Measurement Per Unit") }
            )
            Spacer(modifier = Modifier.height(16.dp))

//    ***********  StartDate Picker *************
            //TODO: Add Date Picker
//    ***********  ExpirationDate Picker  *************
            //TODO: Add Date Picker

        }
        
    }
}
