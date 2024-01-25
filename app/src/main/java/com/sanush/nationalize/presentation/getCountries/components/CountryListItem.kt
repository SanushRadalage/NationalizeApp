package com.sanush.nationalize.presentation.getCountries.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sanush.nationalize.R
import com.sanush.nationalize.domain.model.Country

/**
 * Country list item to show country name and probability
 */
@Composable
fun CountryListItem(
    country: Country
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = country.countryId,
            style = MaterialTheme.typography.bodyLarge, overflow = TextOverflow.Ellipsis
        )
        Row {
            Text(
                text = stringResource(id = R.string.probability),
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "%.2f".format(country.probability),
                color = if (country.probability > 0.5) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
