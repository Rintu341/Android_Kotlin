package com.example.treasuresfoundgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.treasuresfoundgame.ui.theme.TreasuresFoundGameTheme
import java.util.Random
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasuresFoundGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    CaptainGame()
                }
            }
        }
    }
    @Composable
    fun CaptainGame() {
        var treasuresCount: Int by remember {
            mutableStateOf(0)
        }
        var direction: String by remember {
            mutableStateOf("West")
        }
        var flag by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column {
                Spacer(Modifier.height(32.dp))
                Text(
                    text = " Treasures Hunter",
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                modifier= Modifier.padding(start = 44.dp)
            )
            {

                Spacer(Modifier.height(16.dp))
                if (flag)
                    Text(text = "Treasures Found")
                else
                    Text(text = "Treasures Not Found")
                Spacer(Modifier.height(16.dp))

                Text(text = "Total No Of Treasures = ${treasuresCount.absoluteValue}")
                Spacer(Modifier.height(16.dp))

                Text(text = "Current Direction $direction")
                Spacer(Modifier.height(16.dp))
                Row {
                    Button(
                        onClick = {
                            if (Random().nextBoolean()) {
                                flag = true
                                treasuresCount += 1

                            } else {
                                flag = false
                            }
                            direction = "North"
                        }
                    ) {
                        Text(text = "Move North")
                    }
                    Spacer(Modifier.padding(end = 8.dp))
                    Button(
                        onClick = {
                            if (Random().nextBoolean()) {
                                flag = true
                                treasuresCount += 1

                            } else {
                                flag = false
                            }
                            direction = "South"
                        }
                    ) {
                        Text(text = "Move South")
                    }
                }
                Row {
                    Button(
                        onClick = {
                            if (Random().nextBoolean()) {
                                flag = true
                                treasuresCount += 1

                            } else {
                                flag = false
                            }
                            direction = "East"
                        }
                    ) {
                        Text(text = "Move East")
                    }
                    Spacer(Modifier.padding(end = 8.dp))
                    Button(
                        onClick = {
                            if (Random().nextBoolean()) {
                                flag = true
                                treasuresCount += 1

                            } else {
                                flag = false
                            }
                            direction = "West"
                        }
                    ) {
                        Text(text = "Move West")
                    }
                }


            }

        }
    }
    @Preview(showBackground = true)
    @Composable
    fun CaptainGamePreview()
    {
        CaptainGame()
    }

}



