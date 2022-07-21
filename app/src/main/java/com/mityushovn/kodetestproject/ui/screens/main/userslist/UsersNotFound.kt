package com.mityushovn.kodetestproject.ui.screens.main.userslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.kodetestproject.R
import com.mityushovn.kodetestproject.ui.theme.KodeTheme

@Composable
fun UsersNotFound(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(80.dp))

        Image(
            painter = painterResource(id = R.drawable.glass_lenc),
            contentDescription = null,
            modifier = Modifier.size(56.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = stringResource(id = R.string.not_found_anybody),
            style = KodeTheme.typography.title3SemiBold,
            color = KodeTheme.colors.textPrimary,
        )

        Spacer(modifier = Modifier.size(12.dp))

        Text(
            text = stringResource(id = R.string.try_correct_request),
            style = KodeTheme.typography.headlineRegular,
            color = KodeTheme.colors.textTertiary,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UsersNotFoundPreview() {
    KodeTheme {
        UsersNotFound(modifier = Modifier.wrapContentWidth())
    }
}