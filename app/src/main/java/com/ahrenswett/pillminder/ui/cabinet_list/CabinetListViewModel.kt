package com.ahrenswett.pillminder.ui.cabinet_list

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import com.ahrenswett.pillminder.util.Route
import com.ahrenswett.pillminder.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CabinetListViewModel @Inject constructor(
    // could these be injected into one class and then injected here?
    private val cabinetRepo: CabinetRepo
): ViewModel() {

    //TODO: needs to be more restrictive for netork and user specific values. should only get users cabinets.

    val cabinets = cabinetRepo.getCabinets()

    private val _uiEvents = Channel<UiEvent>()
    val uiEvent = _uiEvents.receiveAsFlow()

    fun onEvent(event: CabinetListEvent){
         when(event){
             is CabinetListEvent.AddNewCabinet -> {
                 sendUiEvent(UiEvent.Navigate(Route.ADD_EDIT_CABINET.route))
             }
             is CabinetListEvent.ViewCabinet -> {
                 sendUiEvent(
                     UiEvent.Navigate(Route.CABINET_VIEW.route + "?cabinetId=${event.cabinet.name}")
                 )
             }
             else -> Unit
         }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvents.send(event)
        }
    }
}