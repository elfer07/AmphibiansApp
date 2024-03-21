package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.HomeScreen
import com.example.amphibians.ui.screens.HomeViewModel

@Composable
fun AmphibianApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AmphibianTopAppBar() }
    ) {
        val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
        HomeScreen(
            appUiState = homeViewModel.appUiState,
            retryAction = homeViewModel::getAmphibians,
            modifier = Modifier.fillMaxSize(),
            contentPadding = it
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianTopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}