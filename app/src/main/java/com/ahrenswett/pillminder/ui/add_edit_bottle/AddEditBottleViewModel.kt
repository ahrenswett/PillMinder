package com.ahrenswett.pillminder.ui.add_edit_bottle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Consumable
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import com.ahrenswett.pillminder.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditBottleViewModel @Inject constructor(
    private val bottleRepo: BottleRepo,
    private val consumableRepo: ConsumableRepo,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

//  Bottle to pre populate the form when editing an existing bottle
    var bottle by mutableStateOf<Bottle?>(null)
        private set

//  Consumable to pre populate the form when editing an existing bottle
    var consumable by mutableStateOf<Consumable?>(null)
        private set

    //  Consumablelist to pre populate spinner when editing an existing bottle
    var consumables by mutableStateOf(consumableRepo.listConsumables())
        private set

//  Variables to pass back and forth between the view and view model
    var name by mutableStateOf("")
        private set

    var quantity by mutableStateOf(0)
        private set

    var expirationDate by mutableStateOf("") /* TODO Make a date picker event */
        private set

    var startDate by mutableStateOf("") /* TODO Make a date picker event */
        private set

//  CabinetID bottle belongs/will belong to
    val cabinetID = savedStateHandle.get<String>("cabinetID")

//  Channel to send events to the view
    private val _uiEvents = Channel<UiEvent>()
    val uiEvent = _uiEvents.receiveAsFlow()

// Pass events from the UI to the ViewModel
    fun onEvent(event: AddEditBottleEvent){
        when(event){
            is AddEditBottleEvent.OnNameChange -> {
                // Update the name of the bottle in UI's TextField
                name = event.consumableID
            }
            is AddEditBottleEvent.OnQuantityChange -> {
                quantity = event.quantity
            }
            // Submit a new Bottle and Consumable to the database
            is AddEditBottleEvent.OnSubmit ->{
                viewModelScope.launch {
                    // Create a new bottle and consumable
                    val newBottle = Bottle(
                        consumableID = name,
                        quantityInBottle = quantity,
                        expirationDate = expirationDate,
                        startDate = startDate,
                        cabinetID = cabinetID!!
                    )
                    TODO("Create a new Consumable or get the ID of an existing Consumable. Implement a trie to search for a Consumable by name")

                }
            }
        }
    }


    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvents.send(event)
        }
    }

}