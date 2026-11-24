package com.example.holladays

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.holladays.ui.theme.HollaDaysTheme
import java.util.Calendar


object UtilInterfaces {

    interface InfoApp {

        fun createTitleShown(title: String): String
        fun isUiReady(isReady: Boolean): Boolean
    }
}

class Utilities : UtilInterfaces.InfoApp {
    override fun createTitleShown(title: String): String {
        return title.uppercase()
    }

    override fun isUiReady(isReady: Boolean): Boolean {
        return isReady
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val titleClass = Utilities()
        val titleBased = titleClass.createTitleShown("What Time | Holiday Is it!")

        setContent {
            HollaDaysTheme {
                createText(titleBased)
                createButtons()
                CreateHolidays()
            }
        }
    }
}

object Holidays {

    fun isChristmas(isChristmasDay: Boolean, textLabel: String): String {
        if (isChristmasDay) {

            return textLabel
        }

        return textLabel
    }

    fun isThanksGiving(isThanks: Boolean, textLabel: String): String {

        if (isThanks) {

            return textLabel
        }

        return textLabel
    }

}


fun christmas(): String {

    return Holidays.isChristmas(true, "Merry Christmas")
}

fun thanksgiving(): String {

    return Holidays.isThanksGiving(true, "Merry Christmas")
}


@SuppressLint("ComposableNaming")
@Composable
fun createButtons() {

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 220.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {},
            modifier = Modifier.width(300.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(20, 20, 20),
                contentColor = Color(255, 255, 255)
            ),


        ) {


            val month = Calendar.getInstance().get(Calendar.MONTH)
            val dayTimeHoliday = Calendar.getInstance().get(Calendar.DATE)
            if (month == 12 && dayTimeHoliday == 25) {
                Text(text = thanksgiving())
            }

            Text("Christmas | December")
        }
    }
}


@Composable
fun CreateHolidays() {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(20, 20, 20),
                contentColor = Color(255, 255, 255)
            )

        ) {

            val month = Calendar.getInstance().get(Calendar.MONTH)
            val dayTimeHoliday = Calendar.getInstance().get(Calendar.DATE)
            if (month == 12 && dayTimeHoliday == 25) {
                Text(text = christmas())
            }

            Text("Thanks Giving / November".uppercase())
        }
    }
}

@SuppressLint("ComposableNaming")
@Composable
fun createText(textTitle: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = textTitle,
            color = Color(0, 0, 0),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
    }
}