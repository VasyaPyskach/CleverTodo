package com.torsoft.clevertodo.ui.screens.home.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class HomeTodoItem(
    val id: Int,
    val text: String,
    val isChecked: Boolean
)

@Composable
fun HomeTodoItemView(
    modifier: Modifier,
    item: HomeTodoItem,
    onClick: (Int) -> Unit
) {

    Card(
        modifier = modifier
            .height(20.dp)
            .fillMaxWidth()
            .clickable {
                onClick(item.id)
            },
        elevation = 5.dp,

        ) {
        Row {

        }
    }

}
