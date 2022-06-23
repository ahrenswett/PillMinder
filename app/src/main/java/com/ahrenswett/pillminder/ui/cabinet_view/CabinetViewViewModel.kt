package com.ahrenswett.pillminder.ui.cabinet_view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import com.ahrenswett.pillminder.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CabinetViewViewModel @Inject constructor(
    private val cabinetRepo: CabinetRepo,
    private val bottleRepo: BottleRepo,
    private val consumableRepo: ConsumableRepo,
    savedStateHandle : SavedStateHandle
):ViewModel() {
    var cabinet by mutableStateOf<Cabinet?>(null)
        private set

    var name by mutableStateOf("")
        private set

    //Event sending to UI
    private val _uiEvents = Channel<UiEvent>()
    val uiEvent = _uiEvents.receiveAsFlow()

    init {
        /*TODO Fix case of editing name of cabinet*/
//        in case of edit to cabinet name
        Log.i(
            "AddEditCabinetViewModel",
            "${savedStateHandle.keys()}, ${savedStateHandle.get<String?>("cabinetID")}"
        )
        val cabinetID = savedStateHandle.get<String>("cabinetID")
        if (cabinetID != "") {
            viewModelScope.launch {
                cabinet = cabinetRepo.getCabinetById(cabinetID!!)
                this@CabinetViewViewModel.cabinet = cabinet
            }
        }
    }

//    var cabinet by mutableStateOf<Cabinet?>(null)
//        private set
//
//    private val _uiEvents = Channel<UiEvent>()
//    val uiEvent = _uiEvents.receiveAsFlow()
//
//    init {
//        val cabinetID = savedStateHandle.get<String>("cabinetID")
//            .also { Log.i("cabinet", savedStateHandle.keys().toString()+" , " + savedStateHandle.get<String>("cabinetID").toString()) }
//        if (cabinetID != "") {
//            viewModelScope.launch {
//                cabinet = cabinetID?.let { cabinetRepo.getCabinetById(it) }
//                this@CabinetViewViewModel.cabinet = cabinet
//            }
//        }
//    }

    fun onEvent(event: CabinetViewEvent){
        when(event){
            is CabinetViewEvent -> Unit
        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch { _uiEvents.send(event) }
    }
}

