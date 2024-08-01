package com.vimalcvs.testebud.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vimalcvs.testebud.R
import com.vimalcvs.testebud.theme.TesteBudTheme
import com.vimalcvs.testebud.util.NavigationHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TesteBudTheme {
                NavigationHost()
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController = rememberNavController()) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val imageHeight = remember { (screenHeight * 0.3f) }
    val cardHeight = remember { (screenHeight * 0.3f) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Image(
                            modifier = Modifier
                                .height(30.dp),
                            painter = painterResource(id = R.drawable.ic_screen),
                            contentDescription = null,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF003559),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(start = 16.dp),
                        imageVector = Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = null
                    )
                }

            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color(0xFFF4F4F5)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_home_bank),
                    contentDescription = null,
                    modifier = Modifier
                        .height(imageHeight)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Welcome to Aman Bank",
                    fontSize = 21.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold

                )
                Spacer(modifier = Modifier.height(16.dp))
                HomeGrid()

                Card(
                    modifier = Modifier
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
                            .fillMaxWidth()
                            .background(color = Color(0xFF003559)),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_ai),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.End)
                                .padding(end = 8.dp)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                        ) {
                            Button(
                                onClick = {

                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color(0xFF004080)
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
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.Center),
                                        text = "Log In",
                                        color = Color(0xFF004080),
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                    )

                                }
                            }

                        }

                    }
                }
            }
        }
    )
}

@Composable
fun HomeGrid() {
    val items = listOf(
        "Account\nDetails" to R.drawable.ic_home_account,
        "Recent\nTransactions" to R.drawable.ic_home_recent,
        "Card\nDetails" to R.drawable.ic_home_card,
        "Locate\nATM" to R.drawable.ic_home_locate,
        "Locate\nBranch" to R.drawable.ic_home_branch,
        "Open\nAccount" to R.drawable.ic_home_men
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                rowItems.forEach { (string, image) ->
                    ItemList(
                        string = string,
                        image = image,
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    )
                }

                if (rowItems.size < 3) {
                    Spacer(
                        modifier = Modifier
                            .weight(3 - rowItems.size.toFloat())
                            .aspectRatio(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemList(string: String, image: Int, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        onClick = {
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.5.dp
        ),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = string,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
        }
    }
}

