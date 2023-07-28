package com.example.compose_application

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.coroutineScope


@Composable
@Preview
fun RecipeCard(recipe: Recipe= defaultRecipes[0], modifier: Modifier?= Modifier.padding(16.dp)) {
     val context = LocalContext.current

    Surface(shape = RoundedCornerShape(8.dp), shadowElevation = 8.dp, modifier = modifier!!) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(painterResource(recipe?.imageResource!!), "",contentScale = ContentScale.Crop, modifier = Modifier
                .fillMaxWidth()
                .height(144.dp))

            Row {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        recipe?.title ?: "No Title",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    for (ingredient in recipe?.ingredients!!) {
                        Text("• $ingredient")
                    }
                }


                // Add the Row composable for the photos
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)) {
                    // Replace the placeholder images with your actual photo assets
                    Image(
                        painter = painterResource(R.drawable.smoothie),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                            .height(100.dp)
                            .clickable {
                                Toast.makeText(context, recipe.title, Toast.LENGTH_SHORT).show()

                            }
                    )
                    Image(
                        painter = painterResource(R.drawable.smoothie),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                            .height(100.dp)
                            .clickable {
                                Toast.makeText(context, recipe.title, Toast.LENGTH_SHORT).show()

                            }
                    )
                }


            }

        }
    }
}



