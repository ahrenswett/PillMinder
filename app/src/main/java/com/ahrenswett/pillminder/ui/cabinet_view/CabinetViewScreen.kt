package com.ahrenswett.pillminder.ui.cabinet_view

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.media.Image
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.magnifier
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
import com.ahrenswett.pillminder.data.type_converters.Converters
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.model.Prescription
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetEvent
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListEvent
import com.ahrenswett.pillminder.util.UiEvent
import com.ahrenswett.pillminder.util.WhatFormIsIt
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
//    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()

    var context = LocalContext.current
//    Tab data
    var tabIndex by remember { mutableStateOf(0)}
    val tabTitles = listOf("Medications","Supplements")

    val cabinet = viewModel.cabinet
    cabinet?.name?.let { Log.i( "CabinetViewScreen", it) }

    var showCustomDialog by remember {
        mutableStateOf(false)
    }
    val testList = listOf(
        Bottle(
            "depakote",
            100,
            Prescription(1,2000,2,"Dr. Christopher Ransom",null),
            "3-3-2052",
            "5-8-2022",
            "Llama2"),
        Bottle(
            "mushies",
            100,
            Prescription(1,2,2,"Dr. Christopher Ransom",null),
            "3-3-2052",
            "5-8-2022",
            "Llama2")
//    TODO: Link the consumable as well
    )

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
                onClick = {
                    viewModel.onEvent(CabinetViewEvent.AddBottle(cabinetID = cabinet!!.name))
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){
//        Display Meds or suplements
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(testList.size){ bottle ->
                CabinetViewItem(
                    bottle = testList[0],
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                            /*TODO(add event for passing bottle back to the viewmodel and adding to room)*/
                        .clickable{ (Toast.makeText(context,"BOOOOOM",Toast.LENGTH_LONG).show())}
                )
            }
        }
    }
}


//            floatingActionButton = {/*TODO: Move all logic with Dialog to Events and Add edit bottle*/
//                FloatingActionButton(
//                    onClick = { showCustomDialog = !showCustomDialog },
//                    modifier = Modifier.wrapContentSize()
//                ){ Icon(imageVector = Icons.Default.Add, contentDescription = "Add") }
//            }
//            ){

//                        if (showCustomDialog) {
//                            BottleBuilder({
//                                showCustomDialog = !showCustomDialog
//                            },tabTitles,tabIndex)
//                        }



//@Composable
//fun BottleBuilder(onDismiss:()->Unit, radioOptions: List<String>,tabIndex: Int ){
//    val context = LocalContext.current
//    var consumableName by remember { mutableStateOf("") }
//
//    Dialog(onDismissRequest = { onDismiss }) {
//        Card(
//            shape = RoundedCornerShape(10.dp),
//            modifier = Modifier.padding(8.dp),
//            elevation = 8.dp
//        ) {
//            //Variables for radio buttons that allow choice of supplement or medication
//            val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[tabIndex] ) }
//
//            Column() {
//                Text(
//                    text = "Which would you like to add?",
//                    modifier = Modifier.padding(8.dp),
//                    fontSize = 20.sp
//                )
//
//                Row(verticalAlignment = Alignment.CenterVertically){
//                    radioOptions.forEach { option ->
//                        RadioButton(
//                            selected = (option == selectedOption),
//                            onClick = { onOptionSelected(option) },
//                        )
//                        Text(text = option.dropLast(1), fontSize = 15.sp,)
//                    }
//                }
//                OutlinedTextField(
//                    value = consumableName,
//                    onValueChange = {consumableName = it},
//                    modifier = Modifier.padding(8.dp),
//                    keyboardActions = KeyboardActions(onDone = {
//                        Toast.makeText(context, consumableName, Toast.LENGTH_SHORT).show()
//                        onDismiss() }),
//                    singleLine = true,
//                    label = { Text(text = "Enter a name")}
//                )
//                Row {
//                    //Cancel Button
//                    OutlinedButton(
//                        onClick = { onDismiss() },
//                        Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp)
//                            .weight(1F)
//                    ) {
//                        Text(text = "Cancel")
//                    }
//                    //Submit Button
//                    Button(
//                        onClick = {
//
//                            Toast.makeText(context, consumableName, Toast.LENGTH_SHORT).show()
//                            onDismiss() },
//                        Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp)
//                            .weight(1F)
//                    ) {
//                        Text(text = "Submit")
//                    }
//                }
//            }
//        }
//    }
//}



