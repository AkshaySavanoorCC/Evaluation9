package com.akshay.evaluation9.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshay.evaluation9.R

@Composable
fun OtpSuccess(){


        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.circle), contentDescription = null,Modifier.size(45.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "CONTINUE TO SMARTFUN",
                color = Color(0xFFEE8664),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            OtpSuccessButton()



    }
}

@Composable
fun OtpSuccessButton(modifier: Modifier = Modifier) {


        Button(
            onClick = { /*TODO*/ },
            modifier = modifier
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
