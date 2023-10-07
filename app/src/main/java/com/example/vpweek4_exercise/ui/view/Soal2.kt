package com.example.vpweek4_exercise.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vpweek4_exercise.R
import com.example.vpweek4_exercise.data.dummy_data
import com.example.vpweek4_exercise.model.categories
import com.example.vpweek4_exercise.model.products

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Soal2View(categories: List<categories>, products: List<products>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tokopedia", fontWeight = FontWeight.Bold) },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.more_vert),
                        contentDescription = "More Vert"
                    )
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 65.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.blog_banner_tokopedia_fair),
                    contentDescription = "Poster Images",
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(
                    text = "Categories",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 20.dp)
                )

                LazyRow {
                    items(categories) {
                        CategoryCard(it, Modifier.fillMaxSize())
                    }
                }

                Text(
                    text = "Products",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 15.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                ) {
                    items(products) {
                        ProductCard(
                            it,
                            Modifier
                                .padding(10.dp)
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun CategoryCard(categories: categories, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(start = 15.dp, top = 10.dp)
            .background(Color.White)
            .fillMaxWidth()
            .shadow(8.dp, shape = RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categories.image_path),
                contentDescription = "Category",
                modifier = Modifier.size(115.dp)
            )

            Text(
                text = categories.category_name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "${categories.number_of_items} Products",
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ProductCard(products: products, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .height(290.dp)
            .shadow(8.dp, shape = RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
        ) {
            Image(
                painter = painterResource(id = products.image_path),
                contentDescription = "Product",
                modifier = Modifier.size(180.dp)
            )

            Text(
                text = products.product_name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Rp. ${products.price}",
                fontSize = 14.sp
            )

            Text(
                text = products.location,
                fontSize = 14.sp
            )

            Text(
                text = "${products.sold} Sold",
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal2Preview() {
    Soal2View(dummy_data().get_data_tokopedia_category(), dummy_data().get_data_tokopedia_product())
}