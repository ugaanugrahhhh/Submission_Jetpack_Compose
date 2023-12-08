package com.dicoding.jetskindamage.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.jetcoffee.R
import com.dicoding.jetskindamage.data.FacialRepository
import com.dicoding.jetskindamage.model.SkinModel
import com.dicoding.jetskindamage.viewmodel.SkinDamageViewModel
import com.dicoding.jetskindamage.viewmodel.ViewModelFactory


@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = OutlinedTextFieldDefaults.colors(),
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
fun HomeContent(
    skinViewModel: SkinDamageViewModel = viewModel(factory = ViewModelFactory(FacialRepository())),
    navigateToDetail: (Int) -> Unit
) {
    val skin by skinViewModel.skinDamage.collectAsState()
    val query by skinViewModel.query

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            SearchBar(
                query,
                skinViewModel::search
            )
        }
        items(skin, key = { it.id }) { skin ->
            CardItem(
                item = skin,
                modifier = Modifier
                    .clickable { navigateToDetail(skin.id) }
            )
        }
    }
}

@Composable
fun CardItem(
    item: SkinModel,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = item.imgSkinProblem),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(width = 150.dp, height = 200.dp)
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                Text(
                    modifier = modifier
                        .padding(8.dp),
                    text = item.titleSkinProblem,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    modifier = modifier
                        .padding(8.dp),
                    text = item.dateSkinProblem,
                    fontSize = 12.sp
                )
                Text(
                    modifier = modifier
                        .padding(8.dp),
                    text = item.descSkinProblem,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 4
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSearch(
    skinViewModel: SkinDamageViewModel = viewModel(factory = ViewModelFactory(FacialRepository()))
) {
    val query by skinViewModel.query
    SearchBar(
        query,
        skinViewModel::search
    )
}

@Preview
@Composable
fun PreviewCardItem() {
    val skin = SkinModel(
        1012,
        R.drawable.icon_category_measles,
        "Measles symptoms to watch for after worrying rise in cases",
        "11/9/2023",
        "According to the most recent government data on MMR, there have been 149 lab confirmed cases of measles in England this year - with London being the worst hit, representing over half of those cases, at 89[^1^][1].",
        "English",
        "https://www.facebook.com/groups/1070818402932935/",
        "https://twitter.com/Measles",
        "https://instagram.com/measles",
        "Measles"
    )
    CardItem(skin)
}

@Preview
@Composable
fun PreviewSkinList() {
//    HomeContent(navigateToDetail = )
}
