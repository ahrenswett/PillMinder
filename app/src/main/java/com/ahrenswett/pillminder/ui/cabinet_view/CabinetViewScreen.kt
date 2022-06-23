package com.ahrenswett.pillminder.ui.cabinet_view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.model.Bottle
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
    onPopBackStack: () -> Unit,
    viewModel : CabinetViewViewModel = hiltViewModel(),
){
    val scaffoldState = rememberScaffoldState()
    val cabinet = viewModel.cabinet
    cabinet?.name?.let { Log.i( "CabinetViewScreen", it) }


//    LaunchedEffect(key1 = true){
//        viewModel.uiEvent.collect { event ->
//            when(event){
//                is UiEvent.PopBackStack -> onPopBackStack()
//                else -> Unit
//            }
//        }
//    }

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
        }
    ){
        Column{
            Text(text = "IM A ${cabinet?.name}")
        }
    }
}