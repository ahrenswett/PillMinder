package com.ahrenswett.pillminder.ui.cabinet_list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

fun CabinetListItem(
    cabinet: Cabinet,
    onEvent: (CabinetListEvent) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = cabinet.name.replaceFirstChar(Char::titlecase),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = {CabinetListEvent.AddBottleToCabinet(cabinet)}){}
    }
    Spacer(modifier = Modifier.width(8.dp))
}

//@Preview
//@Composable
//fun DefaultPreview() {
//        CabinetListItem(
//            Cabinet("Ahren's"),
//            modifier = Modifier,
////            onEvent = Unit,
//        )
//}
