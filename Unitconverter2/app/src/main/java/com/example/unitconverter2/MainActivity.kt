package com.example.unitconverter2

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter2.ui.theme.Unitconverter2Theme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unitconverter2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(modifier: Modifier = Modifier) {

    var inputValue by rememberSaveable {
        mutableStateOf(" ")
    }
    var outputValue by rememberSaveable {
        mutableStateOf("")
    }
    var outputUnit by rememberSaveable {
        mutableStateOf("Centimeter")
    }
    var inputUnit by rememberSaveable {
        mutableStateOf("Meter")
    }
    val oExpand = rememberSaveable {
        mutableStateOf(false)
    }
    val iExpand = rememberSaveable {
        mutableStateOf(false)
    }
    Column (
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier.height(16.dp))
        Text(
            text = "Unit Converters",
            fontSize = 32.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
    }
    Column (
        modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = inputValue,
            onValueChange ={inputValue = it} ,
            label = {Text("Enter value")},
            singleLine = true
        )
        Spacer(modifier.height(16.dp))
        Row()
        {
            //input Button
            Box {
                Button(
                    onClick = { iExpand.value = true },
                    colors =  ButtonDefaults.buttonColors(
                        colorResource(id =R.color.DropDownButton)
                    )
                ) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Drop")
                }
                DropdownMenu(expanded =iExpand.value, onDismissRequest = { iExpand.value = false })
                {
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            iExpand.value = false
                            inputUnit = "Centimeter"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            iExpand.value = false
                            inputUnit = "Meter"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            iExpand.value = false
                            inputUnit = "Feet"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            iExpand.value = false
                            inputUnit = "Millimeter"
                        }
                    )
                }
            }
            Spacer(modifier.padding(end = 16.dp))
            Image(
                painter = painterResource(R.drawable.arrowimage),
                contentDescription = "Arrow image",
                Modifier
                    .width(32.dp)
                    .height(48.dp),

            )
            Spacer(modifier.padding(start = 16.dp))
            //output Button
            Box {
                Button(
                    onClick = { oExpand.value = true },
                    colors =  ButtonDefaults.buttonColors(
                        colorResource(id =R.color.DropDownButton)
                    )
                ) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpand.value, onDismissRequest = { oExpand.value = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            oExpand.value = false
                            outputUnit = "Centimeter"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            oExpand.value = false
                            outputUnit = "Meter"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            oExpand.value = false
                            outputUnit = "Feet"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            oExpand.value = false
                            outputUnit  = "Millimeter"
                        }
                    )
                }
            }
        }
        Spacer(modifier.height(16.dp))
        Row(
            modifier.padding(start = 32.dp,end= 32.dp)
        ) {
            Button(
                onClick = {
                    outputValue = Convertion(inputValue, outputUnit, inputUnit)
                },
                colors = ButtonDefaults.buttonColors(
                    Color.Gray,
                    contentColor = Color.Cyan
                ),
                shape = RoundedCornerShape(topStart = 10.dp,bottomEnd = 10.dp),
                border = BorderStroke(1.dp, color = Color.Black)
            ) {
                Text(
                    text = "Calculate",
                    modifier
                        .fillMaxWidth()
                        .height(36.dp),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier.height(16.dp))
        Text(text= "Result : $outputValue $outputUnit",fontSize = 24.sp )

    }
}
// convert one unit to another
fun Convertion(inputValueDouble: String, outputConversionUnit:String,inputConversionUnit:String):String
{
    val convertionFactor = mapOf(
        "Meter" to 1.0,
        "Centimeter" to 100.0,
        "Feet" to 3.28084,
        "Millimeter" to 1000.0
    )
     val inputValue = inputValueDouble.toDoubleOrNull()?:0.0
    //formula for calculate
     val result = (inputValue * convertionFactor[outputConversionUnit]!! * 100.0 / convertionFactor[inputConversionUnit]!!).roundToInt() / 100.0
    return result.toString();
}



@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    Unitconverter2Theme {
        UnitConverter()
    }
}