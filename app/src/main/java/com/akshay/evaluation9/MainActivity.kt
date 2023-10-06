package com.akshay.evaluation9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akshay.evaluation9.ui.theme.CardRecyclerView
import com.akshay.evaluation9.ui.theme.CardView
import com.akshay.evaluation9.ui.theme.DropDownMenu
import com.akshay.evaluation9.ui.theme.DropDownWithSelected
import com.akshay.evaluation9.ui.theme.Evaluation9Theme
import com.akshay.evaluation9.ui.theme.OtpSuccess
import com.akshay.evaluation9.ui.theme.OtpVerification

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Evaluation9Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CardView()
//                        DropDownWithSelected()
//                        OtpVerification()
//                        OtpSuccess()
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Evaluation9Theme {
        Greeting("Android")
    }
}