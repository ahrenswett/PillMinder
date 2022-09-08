package com.ahrenswett.pillminder.ui.cabinet_view

import android.media.Image
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListEvent
import com.ahrenswett.pillminder.util.UiEvent
import kotlinx.coroutines.flow.collect

/*TODO:
*   - Add Floating action button to add bottles
*       - add reminder at time of adding new bottle
*   - Add list of bottles
*       - clicking a bottle just expands for details
*           - has edit option
*       - swiping deletes
*           - implement snackbar undo delete
*   - Add hamburger menu
*       - delete cabinet
*       - edit cabinet
*/

@Composable
fun CabinetViewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    onPopBackStack: () -> Unit,
    viewModel : CabinetViewViewModel = hiltViewModel(),
){
    val scaffoldState = rememberScaffoldState()
    var tabIndex by remember { mutableStateOf(0)}
    var tabTitles = listOf("Medication","Supplements")

    val cabinet = viewModel.cabinet
    cabinet?.name?.let { Log.i( "CabinetViewScreen", it) }


    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    Scaffold (
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    if (cabinet != null) {
                        Text(
                            text = cabinet.name,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                println("FloatingActionButton clicked, cabinet: ${cabinet?.name}")
                viewModel.onEvent(CabinetViewEvent.AddBottle(cabinet!!.name))
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){

//        Tabs for displaying
        Column() {
            TabRow( selectedTabIndex = tabIndex ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = { Text(text = title) }
                    )
                }
            }
        }

    }
}
