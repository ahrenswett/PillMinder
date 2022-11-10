package com.ahrenswett.pillminder.ui.cabinet_view

import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListEvent

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet



/* TODO & CONSIDER
    * what should a cabinet ui show?
        * Number of bottles?
        * Swipe to add bottle?
        * Add bottle button?
        * Change color based on
            * green if current on meds/supplements
            * red if missed but can still take
            * black if missed for the day
            * orange / yellow gradient leading up to reminder time
        * Owners name
        * Picture of owner or icon
        * Countdown timer to next consumable and the name of the consumable
 */

@Composable
fun CabinetViewItem(
    bottle: Bottle,
    onEvent: (CabinetViewEvent) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp,1.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${bottle.consumableID.replaceFirstChar(Char::titlecase)} ${bottle.prescription.dose}" ,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
