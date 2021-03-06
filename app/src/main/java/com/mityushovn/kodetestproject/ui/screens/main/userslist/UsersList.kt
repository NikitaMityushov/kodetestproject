package com.mityushovn.kodetestproject.ui.screens.main.userslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.kodetestproject.domain.models.UserDomain
import com.mityushovn.kodetestproject.ui.theme.KodeTheme
import kotlinx.coroutines.launch

private const val START_POSITION = 0

/**
 * UsersList component.
 */
@Composable
fun UsersList(
    modifier: Modifier = Modifier,
    list: List<UserDomain>,
    onListItemClick: (UserDomain) -> Unit
) {
    /*
     *  is used to store the current list state.
     */
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(top = 16.dp)
    ) {
        this.items(key = { user -> user.id }, items = list) { user ->
            UsersListItem(
                userDomain = user,
                modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
                onListItemClick = onListItemClick
            )
        }
        /*
            scrolling to the first lists item after each filter changes
         */
        scope.launch {
            listState.scrollToItem(START_POSITION)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
    val sourceList = listOf(
        UserDomain(
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
        UserDomain(
            id = "2",
            firstName = "Петр",
            lastName = "Петров",
            userTag = "@ivanov",
            position = "Программист",
            avatarUrl = "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
            department = "Программист",
            age = "30",
            phone = "+79998887766",
            birthdate = "01.01.2000",
        ),
        UserDomain(
            id = "3",
            firstName = "Сергей",
            lastName = "Сергеев",
            userTag = "@ivanov",
            position = "Программист",
            avatarUrl = "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
            department = "Программист",
            age = "30",
            phone = "+79998887766",
            birthdate = "01.01.2000",
        )
    )

    KodeTheme {
        UsersList(
            list = sourceList,
            onListItemClick = {}
        )
    }
}


