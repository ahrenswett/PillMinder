package com.ahrenswett.pillminder.ui.add_edit_cabinet

import android.util.Log
import android.util.Log.INFO
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditCabinetViewModel @Inject constructor(
    private val repo: CabinetRepo,
    savedStateHandle: SavedStateHandle
): ViewModel(){
//    holds the state so that the name will populate as the user types
    var cabinet by mutableStateOf<Cabinet?>(null)
        private set

    var name by mutableStateOf("")
        private set

    //Event sending to UI
    private val _uiEvents = Channel<UiEvent>()
    val uiEvent = _uiEvents.receiveAsFlow()

    init{
        /*TODO Fix case of editing name of cabinet*/
//        in case of edit to cabinet name
        Log.i("AddEditCabinetViewModel", "${savedStateHandle.keys()}, ${savedStateHandle.get<String?>("cabinetID")}")
        val cabinetID = savedStateHandle.get<String>("cabinetID")
        if(cabinetID != ""){
            viewModelScope.launch {
                cabinet = repo.getCabinetById(cabinetID!!)
                this@AddEditCabinetViewModel.cabinet = cabinet
            }
        }
    }

    fun onEvent(event: AddEditCabinetEvent){
        when(event){
            is AddEditCabinetEvent.onNameChange -> {
                // Update the UI
                name = event.name
            }
            is AddEditCabinetEvent.onSubmit -> {
                //put cabinet in the database
                viewModelScope.launch {
                    if(name.isBlank()){
                        sendUiEvent(UiEvent.ShowSnackBar(
                            message = "The Cabinet must have a name"
                        ))
                    }
                    repo.insertCabinet(cabinet = Cabinet(name))
                }
                sendUiEvent(UiEvent.PopBackStack)
            }
        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch { _uiEvents.send(event) }
    }

}