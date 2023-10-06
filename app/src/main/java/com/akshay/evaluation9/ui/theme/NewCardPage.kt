package com.akshay.evaluation9.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.akshay.evaluation9.model.CardList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var location by remember {
        mutableStateOf("")
    }
    Column {
    ExposedDropdownMenuBox(expanded = isExpanded,
        onExpandedChange = {
        newValue ->
        isExpanded = newValue
        },
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()) {


        TextField(
            value = location,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = "Semnox Mangalore")
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )


        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = {
            isExpanded = false
        },


        ) {
            DropdownMenuItem(


                text = {
                Text(text = "Semnox Mangalore")
            }, onClick = {
                location = "Semnox Mangalore"
                isExpanded = false
            })
            DropdownMenuItem(
                text = {
                Text(text = "Semnox Bangalore")
            }, onClick = {
                location = "Semnox Bangalore"
                isExpanded = false
            })
            DropdownMenuItem(
                text = {
                Text(text = "Semnox Mumbai")
            }, onClick = {
                location = "Semnox Mumbai"
                isExpanded = false
            })
        }
    }
    }
}

@Composable
fun CardRecyclerView(modifier: Modifier = Modifier){
    val offersList = CardList.loadOffers()

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
        items(offersList){
                Card (modifier = Modifier
                    .height(120.dp)
                    .padding(8.dp)){
                    Column (modifier = Modifier.padding(8.dp)){
                        Image(modifier = Modifier
                            .height(25.dp)
                            .width(25.dp),painter = painterResource(id = it.image), contentDescription = null)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = it.title, color = Color(0xFF797777))
                    }
                }
            }

        }
}

@Composable
fun CardView(){
    Column {
        DropDownMenu()
        CardRecyclerView()
    }
}


