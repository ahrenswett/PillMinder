package com.ahrenswett.pillminder.ui.cabinet_view

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.media.Image
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.room.util.TableInfo
import com.ahrenswett.pillminder.R
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetEvent
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CabinetViewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    onPopBackStack: () -> Unit,
    viewModel : CabinetViewViewModel = hiltViewModel(),
){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()

//    Tab data
    var tabIndex by remember { mutableStateOf(0)}
    val tabTitles = listOf("Medications","Supplements")

    val cabinet = viewModel.cabinet
    cabinet?.name?.let { Log.i( "CabinetViewScreen", it) }

    var showCustomDialog by remember {
        mutableStateOf(false)
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
            FloatingActionButton(
                onClick = { showCustomDialog = !showCustomDialog },
                modifier = Modifier.wrapContentSize()
            ){ Icon(imageVector = Icons.Default.Add, contentDescription = "Add") }
        }
    ){
        Column() {
            if (showCustomDialog) {
                BottleBuilder({
                    showCustomDialog = !showCustomDialog
                },tabTitles,tabIndex)
            }
        }
    }
}


@Composable
fun BottleBuilder(onDismiss:()->Unit, radioOptions: List<String>,tabIndex: Int ){
    val context = LocalContext.current
    var consumableName by remember { mutableStateOf("") }

    Dialog(onDismissRequest = { onDismiss }) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(8.dp),
            elevation = 8.dp
        ) {
//      Variables for radio buttons that allow choice of supplement or medication
//            val radioOptions = listOf("Medication", "Supplement")
            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[tabIndex] ) }

            Column() {
                Text(
                    text = "Which would you like to add?",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 20.sp
                )

                Row(verticalAlignment = Alignment.CenterVertically){
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
                    onValueChange = {consumableName = it},
                    modifier = Modifier.padding(8.dp),
                    keyboardActions = KeyboardActions(onDone = {
                        Toast.makeText(context, consumableName, Toast.LENGTH_SHORT).show()
                        onDismiss() }),
                    singleLine = true,
                    label = { Text(text = "Enter a name")}
                )
                Row {
                    OutlinedButton(
                        onClick = { onDismiss() },
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1F)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = {
//                            pass it back to the VM and build up the consumable info
                            Toast.makeText(context, consumableName, Toast.LENGTH_SHORT).show()
                            onDismiss() },
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





    // state hoisting needs to be explored.
//    TODO: build out a form that passes data bak to the view model and then to the repository/ database
//    name: make use of the trie
//    measurement per unit
//    medication toggle
//        if medication then give option for precriptions
}



