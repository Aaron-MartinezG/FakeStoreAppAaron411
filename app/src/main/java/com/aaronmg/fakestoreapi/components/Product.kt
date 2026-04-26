package com.aaronmg.fakestoreapi.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.aaronmg.fakestoreapi.models.Product
import com.aaronmg.fakestoreapi.models.productList
import com.aaronmg.fakestoreapi.ui.theme.FakeStoreAPITheme

@Composable
fun ProductItem(
    product: Product,
    onClick : () -> Unit = { }
){
    Column(
        modifier = Modifier
            .padding(20.dp)
            .height(200.dp)
            .fillMaxWidth()
            .clickable{
                onClick()
            }
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Text(
            text = product.title,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview()
@Composable
fun ProductItemPreview(){
    FakeStoreAPITheme() {
        ProductItem(
            product = productList[0]
        )
    }
}