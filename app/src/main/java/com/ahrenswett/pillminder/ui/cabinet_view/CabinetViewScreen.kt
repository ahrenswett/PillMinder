package com.ahrenswett.pillminder.ui.cabinet_view

import android.app.AlertDialog
import android.media.Image
import android.util.Log
import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.room.util.TableInfo
import com.ahrenswett.pillminder.R
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
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

//    Tab data
    var tabIndex by remember { mutableStateOf(0)}
    val tabTitles = listOf("Medication","Supplements")

    val cabinet = viewModel.cabinet
    cabinet?.name?.let { Log.i( "CabinetViewScreen", it) }





    //    Dialog manager
    val dialogState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    if(dialogState.value) {
        var consumableName by rememberSaveable{ mutableStateOf("Name") }
        Dialog(
            onDismissRequest = { dialogState.value = false },
            properties = DialogProperties(),
            content = { Column() {
                Text(text = "What would you like to Track", Modifier.padding(10.dp))
                TextField(value = consumableName, onValueChange = {consumableName = it} )
            }},
        )
    }










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
        bottomBar = {
            TabRow(selectedTabIndex = tabIndex) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = { Text(text = title) }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                dialogState.value = true
            }){
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){
//        Tabs for displaying
        Column() {

        }

    }
}



@Composable
fun BottleBuilder(dialogState: MutableState<Boolean>){
    // state hoisting needs to be explored.
//    TODO: build out a form that passes data bak to the view model and then to the repository/ database
//    name: make use of the trie
//    measurement per unit
//    medication toggle
//        if medication then give option for precriptions



}



