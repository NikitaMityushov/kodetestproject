package com.mityushovn.kodetestproject.ui.screens.main.userslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mityushovn.kodetestproject.domain.models.UserDomain
import com.mityushovn.kodetestproject.R
import com.mityushovn.kodetestproject.ui.theme.KodeTheme

/**
 * [RefreshingUsersList] item component
 */
@Composable
fun UsersListItem(
    userDomain: UserDomain,
    modifier: Modifier = Modifier,
    onListItemClick: (UserDomain) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onListItemClick(userDomain)
            }
    ) {
        UserPhoto(
            avatarUrl = userDomain.avatarUrl,
            modifier = modifier
        )
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = userDomain.firstName,
                    style = KodeTheme.typography.headlineMedium,
                    color = KodeTheme.colors.textPrimary
                )
                Text(
                    text = userDomain.lastName,
                    style = KodeTheme.typography.headlineMedium,
                    color = KodeTheme.colors.textPrimary
                )
                Text(
                    text = userDomain.userTag,
                    style = KodeTheme.typography.subheadMedium,
                    color = KodeTheme.colors.textTertiary
                )
            }
            Text(
                text = userDomain.position,
                style = KodeTheme.typography.caption1Regular,
                color = KodeTheme.colors.textSecondary
            )
        }
    }
}

/**
 * AsyncImage component for user avatar
 */
@Composable
fun UserPhoto(
    avatarUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = avatarUrl,
        contentDescription = null,
        modifier = modifier
            .clip(CircleShape)
            .size(72.dp),
        placeholder = painterResource(id = R.drawable.placeholdergoose),
    )
//    Image(
//        painter = painterResource(id = R.drawable.placeholdergoose),
//        contentDescription = null,
//        modifier = Modifier
//            .clip(CircleShape)
//            .size(72.dp)
//    )
}

/**
 * [RefreshingUsersList] item component preview
 */
@Preview(showBackground = true)
@Composable
fun PreviewUsersListItem() {
    KodeTheme {
        UsersListItem(
            userDomain = UserDomain(
                id = "1",
                firstName = "Иван",
                lastName = "Иванов",
                userTag = "@ivanov",
                position = "Программист",
                avatarUrl = "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
                department = "Программист",
                age = "30",
                phone = "+79998887766",
                birthdate = "01.01.2000",
            ),
            onListItemClick = {
                println("Clicked")
            }
        )
    }
}
