package com.ahrenswett.pillminder.ui.add_edit_bottle

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Consumable
import com.ahrenswett.pillminder.domain.model.Form
import com.ahrenswett.pillminder.domain.model.Prescription
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
//    val questions : List<String> = listOf<String>(
//        "Is this a medication?",
//        "What is the name of the bottle contents?",
//        "How many servings are in the bottle?",
//        "What is the form of this item",
//        "how is this item measured",
//        "What is the dose for this item?",
//        "How many times a day is this taken?",
//        "What's the prescribers name?",
//        "What's the prescribers phone number?",
//        "what is the expiration date?",
//        "when was this item started?",
//    ),
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

    var id by mutableStateOf(0)
        private set

    var quantity by mutableStateOf(0)
        private set

    var dose by mutableStateOf(0)
        private set

    var expirationDate by mutableStateOf("") /* TODO Make a date picker event */
        private set

    var startDate by mutableStateOf("") /* TODO Make a date picker event */
        private set

    var mesurementPerUnit by mutableStateOf(0F)
        private set

    //  Prescription info variables
    var timesToTakePerDay by mutableStateOf(0)
        private set

    var prescribingDoc by mutableStateOf("")
        private set

    var phoneNumber by mutableStateOf("")
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
            is AddEditBottleEvent.OnMeasurementChange -> {
                mesurementPerUnit = event.measurement
            }
            is AddEditBottleEvent.OnDoseChange -> {
                dose = event.dose
            }
            is AddEditBottleEvent.OnExpirationDateChange -> {
                expirationDate = event.expirationDate
            }
            is AddEditBottleEvent.OnStartDateChange -> {
                startDate = event.startDate
            }

            // Submit a new Bottle and Consumable to the database
            is AddEditBottleEvent.OnSubmit ->{
                viewModelScope.launch {
                    // Create a new bottle and consumable
                    val newBottle = Bottle(
                        consumableID = name,
                        quantityInBottle = quantity,
                        prescription = Prescription(
                            id = id,
                            dose = dose,
                            timesToTakePerDay = timesToTakePerDay,
                            prescribingDoc = prescribingDoc,
                            phoneNumber = phoneNumber,
                        ),
                        expirationDate = expirationDate,
                        startDate = startDate,
                        cabinetID = cabinetID!!
                    )
//  TODO ("Implement a trie to search for a Consumable by name as its typed in the TextField if none found create a new Consumable")
                    val newConsumable = Consumable(
                        name = name,
                        measurementPerUnit = mesurementPerUnit, // TODO("Add a measurement Spinner")
                        medication = true, // TODO("Add a medication checkbox")
                        form = Form.TABLET.form, // TODO("Add a form Spinner")
                    )
                    bottleRepo.addBottle(newBottle)
                    consumableRepo.addNewConsumable(newConsumable)
                }
                sendUiEvent(UiEvent.PopBackStack)
            }
        }
    }


    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvents.send(event)
        }
    }

}