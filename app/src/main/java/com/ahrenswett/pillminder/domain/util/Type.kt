package com.ahrenswett.pillminder.domain.util

sealed class Type{
    object Medication: Type()
    object Supplement: Type()
}
