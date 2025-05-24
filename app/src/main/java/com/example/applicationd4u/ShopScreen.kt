package com.example.applicationd4u

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import coil.compose.rememberImagePainter


@Composable
fun ShopScreen() {

    val products = listOf(
        Product("Clencera", "French clay and algae-powered cleanser", "RS. 355.20", "RS. 444.00", true, R.drawable.product_image),
        Product("Lakme", "Face wash with Viamin C serum.", "RS. 512.20", "RS. 444.00", true, R.drawable.categorysample),
        Product("Afterglow", "French clay and algae-powered cleanser", "RS. 355.20", "RS. 444.00", false, R.drawable.product_image)
    )

    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .fillMaxSize()
        .background(Color.Black)
        .padding(10.dp)) {

        Spacer(Modifier.height(45.dp))

        Text(
            text = "Face Mart",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.tangerine)),
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        Box(modifier = Modifier
            .padding(8.dp, top = 30.dp)
            .fillMaxWidth().height(160.dp)){
            Image(
                painter = painterResource(id = R.drawable.banner_card),
                contentDescription = "Banner",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize(),
            )
            Column( modifier = Modifier.padding(top = 27.dp)) {
                Text(text = "Get 20% off",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 15.dp ))
                Text(text = "till 15th June",
                    color = Color.Green,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp))
                Spacer(Modifier.height(10.dp))
                Text(text = "Shop our exclusive range now !",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 5.dp))
            }
        }
        // Banner


        Spacer(Modifier.height(20.dp))

        // Categories
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            items(10) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(

                        painter = painterResource(id = R.drawable.categorysample),
                        contentDescription = "Category",
                        modifier = Modifier.size(60.dp)
                    )

                    Text(text = "Lakme",
                        color = Color.White,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(3.dp)
                    )
                }

            }
        }


//        // Product Cards
//        LazyColumn(modifier = Modifier.padding(8.dp)) {
//
//
//
//            items(products) { product ->
//                ProductCard(product)
//            }
//        }

        Spacer(modifier = Modifier.height(15.dp))

        products.forEachIndexed { index, product ->
            ProductCard(product)

            if (index != products.lastIndex) {
                Spacer(modifier = Modifier.height(35.dp))
            }
        }

    }
}

@Composable
fun ProductCard(product: Product) {



    Box(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .height(350.dp)) {

        IconButton(
            onClick = { /* handle cart click */ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(30.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.heart1),
                contentDescription = "Like"
            )
        }


        Image(
            painter = painterResource(id = R.drawable.grey_card_svg), // your grey SVG asset
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )





        Column(modifier = Modifier.padding(16.dp)) {
            //For loading images
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .height(120.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box {

                IconButton(
                    onClick = { /* handle cart click */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(50.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cartnew),
                        contentDescription = "Add to cart"
                    )
                }


                Image(
                    painter = painterResource(id = R.drawable.product_title_card), // your title SVG
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize()
                )

                // Texts on top of the SVG
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Text(text = product.name,
                        color = Color.Green,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 4.dp),
                        fontFamily = FontFamily(Font(R.font.tangerine)))
                    Text(text = product.description, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    Text(text = product.price, color = Color.White, fontSize = 14.sp, )
                    Text(
                        text = if (product.inStock) "In stock" else "Out of stock",
                        color = if (product.inStock) Color.Green else Color.Red,
                        fontSize = 14.sp
                    )


                }
            }
        }
    }
}

data class Product(
    val name: String,
    val description: String,
    val price: String,
    val originalPrice: String,
    val inStock: Boolean,
    val imageRes: Int
)


@Preview
@Composable
fun ShopPreview() {
    ShopScreen()
}
