package com.ahrenswett.pillminder.ui.add_edit_bottle

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetEvent
import com.ahrenswett.pillminder.util.BottleBuilder
import com.ahrenswett.pillminder.util.UiEvent
import com.ahrenswett.pillminder.util.WhatFormIsIt
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddEditBottleScreen(
    onPopBackStack: () -> Unit,
    arguments: Bundle?,
    viewModel : AddEditBottleViewModel = hiltViewModel(),
) {
//    val focusRequester = remember { FocusRequester() }
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    //TODO: Validate form so that all fields are filled out before allowing user to save.
    // or just navigate through questions and allow user to save when they are done.
    BottleBuilder(onDismiss = onPopBackStack , tabIndex = arguments!!.getInt("tabIndex"), viewModel)
}