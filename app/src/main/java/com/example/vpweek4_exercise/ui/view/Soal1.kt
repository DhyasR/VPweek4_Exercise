package com.example.vpweek4_exercise.ui.view

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Notification.Action
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpweek4_exercise.R
import com.example.vpweek4_exercise.data.dummy_data
import com.example.vpweek4_exercise.model.line_chat

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Soal1View(lineChat: List<line_chat>) {
    var selectedChatName by rememberSaveable { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Chats") },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.more_vert),
                        contentDescription = "More Vert"
                    )
                }
            )
        },
        content = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(top = 56.dp)
            ) {
                items(lineChat) {
                    ChatCard(
                        it,
                        Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                            .fillMaxSize()
                    )
                }
            }
        }
    )
}

@Composable
fun ChatCard(lineChat: line_chat, modifier: Modifier = Modifier) {
    var isClicked by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (!isClicked) {
                        Toast
                            .makeText(
                                context,
                                "${lineChat.name} Clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    isClicked = !isClicked
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(80.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(start = 5.dp, end = 5.dp)
                    .weight(10f)
            ) {
                Text(
                    text = lineChat.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Text(
                    text = lineChat.chat,
                    fontSize = 14.sp
                )
            }

            Text(
                text = lineChat.date,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    Soal1View(dummy_data().get_data_line())
}