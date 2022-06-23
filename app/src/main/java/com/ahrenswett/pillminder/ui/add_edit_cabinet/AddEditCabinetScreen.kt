package com.ahrenswett.pillminder.ui.add_edit_cabinet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun AddEditCabinetScreen(
    onPopBackStack: () -> Unit,
    viewModel: AddEditCabinetViewModel = hiltViewModel()
){
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    Scaffold (
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton ={
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditCabinetEvent.onSubmit)
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Submit")
            }
        }
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp, 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = viewModel.name,
                singleLine = true,
                onValueChange = {
                    viewModel.onEvent(AddEditCabinetEvent.onNameChange(it))
                },
                placeholder = {
                    val text =   if(viewModel.cabinet != null){
                       viewModel.cabinet?.name
                    }else "Enter a cabinet name"
                    if (text != null) Text(text = text)
                },
                modifier = Modifier.fillMaxWidth(),

            )
        }
    }
}