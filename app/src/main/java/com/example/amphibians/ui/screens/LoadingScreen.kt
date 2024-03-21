package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.R

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
   Image(
       painter = painterResource(id = R.drawable.loading_img),
       contentDescription = stringResource(id = R.string.loading),
       modifier = modifier.size(200.dp)
   )
}