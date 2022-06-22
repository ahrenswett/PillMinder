package com.ahrenswett.pillminder.ui.cabinet_list

import androidx.compose.foundation.clickable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.util.Route
import com.ahrenswett.pillminder.util.UiEvent


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
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp,1.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = cabinet.name.replaceFirstChar(Char::titlecase),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        IconButton(
            onClick = {/*TODO*/},
        ){
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }
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
