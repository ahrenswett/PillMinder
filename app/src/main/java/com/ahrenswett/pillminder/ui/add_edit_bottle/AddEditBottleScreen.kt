package com.ahrenswett.pillminder.ui.add_edit_bottle

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle

@Composable
fun AddEditBottleScreen(
    onPopBackStack: () -> Unit,
    viewModel : AddEditBottleViewModel = hiltViewModel(),
) {
    var scaffoldState = rememberScaffoldState()



}