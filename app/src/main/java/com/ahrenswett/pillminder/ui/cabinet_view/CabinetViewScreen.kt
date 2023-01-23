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
import com.ahrenswett.pillminder.ui.add_edit_bottle.AddEditBottleEvent
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetEvent
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListEvent
import com.ahrenswett.pillminder.util.UiEvent
import com.ahrenswett.pillminder.util.WhatFormIsIt
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count

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

    val bottles = viewModel.bottles.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()

    val context = LocalContext.current

//    bottom bar tab data
    var tabIndex by remember { mutableStateOf(0)}
    val tabTitles = listOf("Medications","Supplements")

    val cabinet = viewModel.cabinet
    cabinet?.name?.let { Log.i( "CabinetViewScreen", it) }

    var showCustomDialog by remember {
        mutableStateOf(false)
    }

//    TODO: Link the consumable as well


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
//                    Add new bottle to cabinet via a dialog
                    viewModel.onEvent(CabinetViewEvent.AddBottle(cabinetID = cabinet!!.name, tabIndex = tabIndex))
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ){

//      Main section: Displays Meds or supplements based on tab selection
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(bottles.value.size){ bottle ->
                CabinetViewItem(
                    bottle = bottles.value[bottle],
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
//                  TODO(go to Bottle View)
                        .clickable{ (Toast.makeText(context,bottles.value[bottle].consumableID,Toast.LENGTH_LONG).show())}
                )
            }
        }
    }
}



