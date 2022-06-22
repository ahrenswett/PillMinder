package com.ahrenswett.pillminder.ui.add_edit_cabinet

sealed class AddEditCabinetEvent {
    // Add / Edit
    data class  onNameChange(val name: String): AddEditCabinetEvent()
    // Cancel

    // Submit
    object onSubmit : AddEditCabinetEvent()
    //add additional User?


}