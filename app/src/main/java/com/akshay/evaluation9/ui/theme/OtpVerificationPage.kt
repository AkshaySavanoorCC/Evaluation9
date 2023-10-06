package com.akshay.evaluation9.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpVerification(){
    Column (
        modifier = Modifier.padding(top = 84.dp, start = 24.dp, end = 24.dp)
    ){
        Text(text = "OTP Verification", color = Color.Black, fontWeight = FontWeight.Bold)
        Text(text = "Enter the One Time Password sent to your \nregistered mobile number ******48.", fontSize = 14.sp)

    }
    Column {
        OtpField()
        VerifyOtp()
    }
    
}

@Composable
fun OtpField() {
    var otp by remember { mutableStateOf(List(6) { "" }) }
    val focusRequesters = remember { (0..5).map { FocusRequester() } }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(200.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 0 until 6) {
                BasicTextField(
                    textStyle = TextStyle(

                       textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    ),
                    value = otp[i],
                    onValueChange = { newOtp ->
                        if (newOtp.length <= 1) {
                            otp = otp.toMutableList().apply {
                                set(i, newOtp)
                            }
                            if (newOtp.isNotEmpty() && i < 5) {
                                focusRequesters[i + 1].requestFocus()
                            } else if (newOtp.isEmpty() && i > 0) {
                                focusRequesters[i - 1].requestFocus()
                            }
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        if (i < 5) {
                            focusRequesters[i + 1].requestFocus()
                        }
                    }),
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF3F5F5),
                            shape = MaterialTheme.shapes.small
                        )
                        .size(60.dp)
                        .padding(12.dp)
                        .focusRequester(focusRequesters[i])
                )
            }
        }
    }
}



@Composable
fun VerifyOtp(modifier: Modifier = Modifier) {


    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier.fillMaxWidth(),


    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEE8664)
            ),
            shape = CutCornerShape(10)
        ) {
            Text(text = "VERIFY OTP")
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Did not receive otp?", fontSize = 14.sp)
        Text(
            text = "RESEND OTP",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}
