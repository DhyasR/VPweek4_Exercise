package com.example.vpweek4_exercise.ui.view

import android.annotation.SuppressLint
import android.icu.text.UnicodeSet.SpanCondition
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.vpweek4_exercise.R
import com.example.vpweek4_exercise.data.DataSource
import com.example.vpweek4_exercise.model.Explore

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Soal4View(explore: List<Explore>) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    Scaffold(
        content = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
            ) {
                item(span = { GridItemSpan(3) }) {
                    TextField(
                        value = text,
                        onValueChange = { newText -> text = newText },
                        label = { Text("Search") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                items(explore) {
                    ExploreCard(it)
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(50.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Home Button",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.home),
                            contentDescription = "Home"
                        )
                    }

                    IconButton(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Search Button",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search"
                        )
                    }

                    IconButton(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Post Button",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.post),
                            contentDescription = "Post"
                        )
                    }

                    IconButton(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Reels Button",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.reels),
                            contentDescription = "Reels"
                        )
                    }

                    IconButton(onClick = {
                        Toast
                            .makeText(
                                context,
                                "Profile Button",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile_picture),
                            contentDescription = "Profile"
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun ExploreCard(explore: Explore) {
    val context = LocalContext.current

    Image(
        painter = painterResource(id = getImageInt(image = explore.content)),
        contentDescription = explore.content,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .aspectRatio(1f)
            .clickable {
                Toast
                    .makeText(context, explore.content, Toast.LENGTH_SHORT)
                    .show()
            }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal4Preview() {
    Soal4View(DataSource().loadExplore())
}