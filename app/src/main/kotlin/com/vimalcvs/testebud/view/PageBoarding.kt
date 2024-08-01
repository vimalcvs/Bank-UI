package com.vimalcvs.testebud.view

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vimalcvs.testebud.R


@Composable
fun BoardingOneScreen(
    navController: NavController = rememberNavController()
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .background(color = Color(0xFF004080))
            .fillMaxSize()
    ) {
        val textHeight = remember { (screenHeight * 0.2f) }
        val imageHeight = remember { (screenHeight * 0.3f) }
        val cardHeight = remember { (screenHeight * 0.3f) }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_screen),
                contentDescription = "Food image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_onboarding_one),
                contentDescription = "Food image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight),
                contentScale = ContentScale.Inside
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(textHeight)
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = "Welcome to Amanbanks",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Your best selection for financial transaction.",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(25.dp))

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp)
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .height(8.dp)
                                .width(40.dp)
                                .clip(MaterialTheme.shapes.small)
                                .background(if (it == 1) Color(0xFFB9D6F2) else Color(0xFF0155AA))
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(cardHeight)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topEnd = 30.dp,
                        topStart = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate("boardingTwo") {
                            popUpTo("boardingOne") { inclusive = true }
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF004080),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 30.dp)
                        .width(screenWidth * 0.85f)
                        .height(50.dp)

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Text(
                            text = "Log In",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .width(screenWidth * 0.85f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(1.dp)
                            .clip(MaterialTheme.shapes.small)
                            .background(color = Color(0xFF004080))
                            .weight(0.1f)
                            .clip(MaterialTheme.shapes.small)

                    )
                    Text(
                        text = "Or",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF004080),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(1.dp)
                            .weight(0.1f)
                            .clip(MaterialTheme.shapes.small)
                            .background(color = Color(0xFF004080))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Go to Home Page",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004080),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            navController.navigate("home") {
                                popUpTo("boardingOne") { inclusive = true }
                            }
                        }
                )
            }


        }
    }
}

@Composable
fun BoardingTwoScreen(
    navController: NavController = rememberNavController()
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Box(
        modifier = Modifier
            .background(color = Color(0xFF004080))
            .fillMaxSize()
    ) {
        val textHeight = remember { (screenHeight * 0.2f) }
        val imageHeight = remember { (screenHeight * 0.3f) }
        val cardHeight = remember { (screenHeight * 0.3f) }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_screen),
                contentDescription = "Food image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_onboarding_two),
                contentDescription = "Food image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight),
                contentScale = ContentScale.Inside
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(textHeight)
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                Text(
                    text = "Manage your Finance",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Your finances at your fingertips.",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(25.dp))

                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp)
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .height(8.dp)
                                .width(40.dp)
                                .clip(MaterialTheme.shapes.small)
                                .background(if (it == 0) Color(0xFFB9D6F2)   else  Color(0xFF0155AA))
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(cardHeight)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topEnd = 30.dp,
                        topStart = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate("home") {
                            popUpTo("boardingTwo") { inclusive = true }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF004080),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 30.dp)
                        .width(screenWidth * 0.85f)
                        .height(50.dp)

                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Text(
                            text = "Log In",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Center),
                            fontWeight = FontWeight.Normal,
                        )

                    }
                }

                Row(
                    modifier = Modifier
                        .width(screenWidth * 0.85f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(1.dp)
                            .clip(MaterialTheme.shapes.small)
                            .background(color = Color(0xFF004080))
                            .weight(0.1f)
                            .clip(MaterialTheme.shapes.small)

                    )
                    Text(
                        text = "Or",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF004080),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(1.dp)
                            .weight(0.1f)
                            .clip(MaterialTheme.shapes.small)
                            .background(color = Color(0xFF004080))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Go to Home Page",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF004080),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            navController.navigate("home") {
                                popUpTo("boardingTwo") { inclusive = true }
                            }
                        }
                )

            }


        }
    }
}


@Preview
@Composable
fun BoardingOneScreenPreview() {
    // BoardingOneScreen()
   BoardingTwoScreen()
}

