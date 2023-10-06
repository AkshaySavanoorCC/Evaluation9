package com.akshay.evaluation9.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshay.evaluation9.R
import com.akshay.evaluation9.model.CardList
import com.akshay.evaluation9.model.OfferModel

@Composable
fun DropDownWithSelected(){
    Column {
        DropDownMenu()
        SelectedCardRecyclerView(offersList = CardList.loadOffers())
        ContinueButton()

    }
}

@Composable
fun ContinueButton(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(
                    0xFFEE8664
                )
            ),
            shape = CutCornerShape(10)
        ) {
            Text(text = "CONTINUE TO PAY - $8")
        }
    }
}
@Composable
fun SelectedCardRecyclerView(modifier: Modifier = Modifier, offersList: List<OfferModel>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        items(offersList) { offer ->
            MyCard(offer = offer)
        }
    }
}

@Composable
fun MyCard(offer: OfferModel) {
    var isClicked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                isClicked = !isClicked
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor =if (isClicked) Color.White else Color(0xFFF3F5F5) ),
        border = if (isClicked) {
            BorderStroke(2.dp, Color(0xFFEE8664))
        } else null,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),
                    painter = painterResource(id = offer.image),
                    contentDescription = null
                )

                if (isClicked) {
                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp),
                        painter = painterResource(id = R.drawable.check),
                        contentDescription = null
                    )
                }
            }


            Spacer(modifier = Modifier.height(10.dp))

            Text(text = offer.title, color = Color(0xFF797777), fontSize = 16.sp)


        }
    }
}