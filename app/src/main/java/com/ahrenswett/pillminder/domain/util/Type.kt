package com.ahrenswett.pillminder.domain.util

import com.ahrenswett.pillminder.domain.model.Consumable
import com.ahrenswett.pillminder.domain.model.Prescription

sealed class Type{
    data class Medication (var medication: Consumable, var prescription: Prescription)
    data class Supplement (var supplement: Consumable, var prescription: Prescription?)
}
