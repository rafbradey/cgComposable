package com.matoza.mychristmasgreetingscomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.matoza.mychristmasgreetingscomposable.ui.theme.MyChristmasGreetingsComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyChristmasGreetingsComposableTheme {
                val navController = rememberNavController()
                NavigationApp(navController)
            }
        }
    }
}

sealed class Routes(val route: String) {
    object FirstFrame : Routes("firstFrame")
    object SecondFrame : Routes("secondFrame")
}

@Composable
fun NavigationApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.FirstFrame.route
    ) {
        composable(Routes.FirstFrame.route) {
            FirstFrame(navController)
        }
        composable(Routes.SecondFrame.route) {
            SecondFrame(navController)
        }
    }
}

@Composable
fun FirstFrame(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .customBackground(),
        containerColor = Color.Transparent
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-20).dp)
                .padding(innerPadding),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            starIcon(
                cdesc = "Star icon"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Greeting(
                message = "Merry Christmas!",
                cdesc_2 = "greeting_image_png",
                name = "RAF BRADEY"
            )

            Spacer(modifier = Modifier.height(18.dp))

            next_btn(
                btn_label = "NEXT (1/2)"
            ) {
                navController.navigate(Routes.SecondFrame.route)
            }

        }

    }
}

@Composable
fun SecondFrame(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .customBackground(),
        containerColor = Color.Transparent
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-20).dp)
                .padding(innerPadding),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            starIcon(
                cdesc = "Star icon"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // "TO: OBI" on the left
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "TO: ",
                    color = colorResource(id = R.color.stark_white),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Obi",
                    color = colorResource(id = R.color.stark_white),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

           //paragrpah
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(
                        color = colorResource(id = R.color.stark_white).copy(alpha = 0.8f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Wishing you all the joy, love, and warmth this holiday season brings. " +
                            "May your days be filled with laughter, cherished moments, and the company " +
                            "of loved ones. Let the season inspire gratitude, kindness, and a renewed sense of hope. " +
                            "Embrace the magic of this time, and may your heart be light with the spirit of giving. " +
                            "Here's to a festive season that brings peace, happiness, and unforgettable memories.",
                    color = colorResource(id = R.color.maron),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 200.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "FROM: ",
                    color = colorResource(id = R.color.stark_white),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "RAF BRADEY",
                    color = colorResource(id = R.color.stark_white),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))



            Spacer(modifier = Modifier.height(24.dp))

            // Back to Home Button
            Button(
                onClick = {
                    navController.navigate(Routes.FirstFrame.route) {
                        popUpTo(Routes.FirstFrame.route) { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.star_orange))
            ) {
                Text(
                    text = "BACK TO HOME",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
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
fun starIcon(cdesc: String) {
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
        fontSize = 50.sp,
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
        fontSize = 20.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Black,
        modifier = Modifier
            .padding(top = 4.dp)
    )
}


@Composable
fun next_btn(btn_label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .height(42.dp)
            .width(300.dp),

        colors = ButtonDefaults
            .buttonColors(containerColor = colorResource(id = R.color.star_orange)),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.stark_white)),
        shape = RoundedCornerShape(30)

    ) {
        Text(
            text = "$btn_label",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )

    }
}
