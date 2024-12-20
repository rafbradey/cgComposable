package com.matoza.mychristmasgreetingscomposable

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matoza.mychristmasgreetingscomposable.ui.theme.MyChristmasGreetingsComposableTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyChristmasGreetingsComposableTheme {
                Scaffold(modifier = Modifier
                        .fillMaxSize()
                        .customBackground(),
                    containerColor = Color.Transparent
                ) { innerPadding ->

                    Column(modifier = Modifier
                            .fillMaxSize()
                            .offset(y=(-20.dp))
                            .padding(innerPadding),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        starIcon(
                            cdesc = "Star icon"
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Greeting(
                            message = "Merry Christmas!",
                            cdesc_2 = "greeting_image_png",
                            name = "RAF"
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        next_btn (
                            btn_label = "NEXT (1/2)"
                        ){
                            /*TODO*/
                        }

                    }

                }
            }
        }


    }
}


sealed class Routes(val route: String) {
    object firstFrame : Routes("firstFrame")
    object secondFrame : Routes("secondFrame")
}

@Composable
fun Modifier.customBackground(
    radius: Float = 0f,
    color: Color = colorResource(id = R.color.maron)
): Modifier {
    return this
        .background(color = color, shape = RoundedCornerShape(radius.dp))
}

@Composable
fun starIcon(cdesc: String){
    Image(

        contentDescription = "$cdesc",
        painter = painterResource(id = R.drawable.star),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(48.dp)

    )
}

@Composable
fun Greeting(name: String, message: String, cdesc_2: String, modifier: Modifier = Modifier) {

    Text(
        text = "$message",
        color = colorResource(id = R.color.stark_white),
        fontSize = 44.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(bottom = 4.dp)
    )

    Image(
        contentDescription = "$cdesc_2",
        painter = painterResource(R.drawable.greet_img),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(500.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(510.dp))
    )

    Text(
        text = "FROM: $name",
        color = colorResource(id = R.color.stark_white),
        fontSize = 18.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Black,
        modifier = Modifier
            .padding(top = 4.dp)


    )
}

@Composable
fun next_btn( btn_label: String,
    onClick: (

            ) -> Unit){
    OutlinedButton(onClick = {
        onClick(/*TODO*/)},
        modifier = Modifier
            .height(42.dp).width(300.dp),

        colors = ButtonDefaults
            .buttonColors(containerColor = colorResource(id = R.color.star_orange)),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.stark_white)),
        shape = RoundedCornerShape(30)

    )
    {
        Text(
            text = "$btn_label",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyChristmasGreetingsComposableTheme {

    }

}