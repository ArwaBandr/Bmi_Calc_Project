package com.example.bmicalcproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalcproject.ui.theme.BmiCalcProjectTheme
import com.example.bmicalcproject.ui.theme.BmiColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiCalcProjectTheme {
                // A surface container using the 'background' color from the theme
BmiInterface()
            }
        }
    }
}

@Composable
fun BmiInterface(viewModel: BmiVewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 38.sp,
                    color =BmiColor.characterColor
                )
            ) {
                append("B")
            }

            append("mi ")

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color =BmiColor.characterColor

                    )
            ) {
                append("C")
            }
            append("alculator")
        }, Modifier.padding(bottom = 100.dp), style = MaterialTheme.typography.titleLarge )

       // Text(text = "Bmi Calculator", Modifier.padding(bottom = 100.dp), style = MaterialTheme.typography.titleLarge )

        var WeightSliderPosition by remember {
            mutableStateOf(0f)
        }
        var HeightSliderPosition by remember {
            mutableStateOf(0f)
        }
        Image(painter = painterResource(id = R.drawable.bmiicon1), contentDescription ="image icon",Modifier.size(70.dp))
        Slider(
            value = WeightSliderPosition,
            onValueChange = { WeightSliderPosition = it },
            valueRange = 1f..150f,
            colors =SliderDefaults.colors(MaterialTheme.colorScheme.primary)

        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)

        ) {

            Text(text = stringResource(id = R.string.weight), style = MaterialTheme.typography.bodyMedium)
            Text(text = "$WeightSliderPosition kg", style = MaterialTheme.typography.bodyMedium)
        }
        Image(painter = painterResource(id = R.drawable.height), contentDescription = "", Modifier.size(70.dp))
        Slider(
            value = HeightSliderPosition,
            onValueChange = { HeightSliderPosition = it },
            valueRange = 40f..200f,
            colors =SliderDefaults.colors(MaterialTheme.colorScheme.primary)

        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()


        ) {
            Text(text = stringResource(id = R.string.height),style = MaterialTheme.typography.bodyMedium)
            Text(text = "$HeightSliderPosition cm",style = MaterialTheme.typography.bodyMedium)
        }
        Button(
            onClick = { viewModel.claclateBmi(HeightSliderPosition, WeightSliderPosition) },
            shape = RoundedCornerShape(3.dp,30.dp,3.dp,30.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Text(text = stringResource(id = R.string.calculate),style = MaterialTheme.typography.bodyMedium)
        }
        Button(
            onClick = {
                 HeightSliderPosition=0f
                WeightSliderPosition= 0f
                viewModel.resultText="" },
            shape = RoundedCornerShape(3.dp,30.dp,3.dp,30.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Text(text = stringResource(id = R.string.Reset),style = MaterialTheme.typography.bodyMedium)
        }
        Divider(modifier = Modifier.padding(top=50.dp), thickness = 1.dp, color = MaterialTheme.colorScheme.primary)
        Text(text = viewModel.resultText, Modifier.padding(top = 20.dp), style = MaterialTheme.typography.bodyMedium)

    }
}


@Preview(showBackground = true)
@Composable
fun BmiScreenPreview() {
    BmiInterface()

}

