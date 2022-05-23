package com.ahrenswett.pillminder.ui.composables

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ahrenswett.pillminder.HoistState

@Composable
fun MenuCard(menuItemText: String){
    Card(modifier = Modifier
        .padding(1.dp)
        .fillMaxWidth()){
        Text(text = menuItemText)
    }
}