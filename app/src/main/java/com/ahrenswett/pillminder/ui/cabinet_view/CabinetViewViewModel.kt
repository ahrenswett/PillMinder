package com.ahrenswett.pillminder.ui.cabinet_view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import com.ahrenswett.pillminder.util.Route
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

        viewModelScope.launch {
            cabinet = cabinetRepo.getCabinetById(cabinetID!!)
            this@CabinetViewViewModel.cabinet = cabinet
        }
    }

    fun onEvent(event: CabinetViewEvent){
        when(event){
            is CabinetViewEvent.AddBottle ->{
                println("CabinetViewViewModel AddBottle")
                sendUiEvent(
                    UiEvent.Navigate(Route.ADD_EDIT_BOTTLE.route + "?cabinetID=${event.cabinetID}" )
                )
            }
            is CabinetViewEvent.OpenMenu ->{
                println("opening menu")
            }
        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch { _uiEvents.send(event) }
    }
}

