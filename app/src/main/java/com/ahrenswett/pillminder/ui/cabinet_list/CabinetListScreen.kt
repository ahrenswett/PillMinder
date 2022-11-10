package com.ahrenswett.pillminder.ui.composables

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListItem
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListEvent
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListViewModel
import com.ahrenswett.pillminder.util.UiEvent
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CabinetListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: CabinetListViewModel = hiltViewModel(),
) {

    val cabinets = viewModel.cabinets.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackBar -> {/*TODO: Implement if needed */
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(CabinetListEvent.AddNewCabinet)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(cabinets.value) { cabinet ->
                Log.i("CabinetListScreen", "Cabinet: $cabinet, ${cabinets.value.indexOf(cabinet)}")
            CabinetListItem(
                    cabinet = cabinet,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onEvent(CabinetListEvent.ViewCabinet(cabinet))
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun CabinetListScreenPreview(){
//    CabinetListScreen(onNavigate = (PillMinderEvents) ->)
}


