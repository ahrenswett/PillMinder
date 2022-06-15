package com.ahrenswett.pillminder.ui.pill_minder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import com.ahrenswett.pillminder.util.Route
import com.ahrenswett.pillminder.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PillMinderViewModel @Inject constructor(
    // could these be injected into one class and then injected here?
    private val cabinetRepo: CabinetRepo,
    private val bottleRepo: BottleRepo,
    private val consumableRepo: ConsumableRepo
): ViewModel() {

    //TODO: needs to be more restrictive for netork and user specific values. should only get users cabinets.
    val cabinets = cabinetRepo.getCabinets()

    private val _uiEvents = Channel<UiEvent>()
    val uiEvent = _uiEvents.receiveAsFlow()

    fun onEvent(event: PillMinderEvents){
         when(event){
             is PillMinderEvents.AddBottleToCabinet -> {
                 sendUiEvent(UiEvent.Navigate(Route.AddBottleToCabinet.route+ "?cabinet=${event.cabinet.name}"))
             }
             is PillMinderEvents.ViewCabinet -> {
                 sendUiEvent(UiEvent.Navigate(Route.ViewCabinet.route + "?cabinet=${event.cabinet.name}"))
             }
         }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch { _uiEvents.send(event) }
    }
}