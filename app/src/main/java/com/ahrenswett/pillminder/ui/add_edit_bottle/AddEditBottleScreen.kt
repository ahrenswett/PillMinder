package com.ahrenswett.pillminder.ui.add_edit_bottle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column() {
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
                modifier = Modifier.fillMaxWidth().focusRequester(focusRequester),
                label = { Text("Name") }
            )

        }
        
    }
}
