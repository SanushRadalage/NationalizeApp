package com.sanush.nationalize.presentation.getCountries.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sanush.nationalize.R

/**
 * This function visible when the user name is empty
 */
@Composable
fun EmptyItem(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.box),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.emptyMessage),
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
    }
}