package com.mityushovn.kodetestproject.ui.screens.main.userslist

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mityushovn.kodetestproject.domain.models.UserDomain
import com.mityushovn.kodetestproject.ui.theme.KodeTheme

/**
 * Represents users list on the screen.
 * Refreshes list when user swipes down on the screen.
 */
@Composable
fun RefreshingUsersList(
    modifier: Modifier = Modifier,
    list: List<UserDomain>,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    onListItemClick: (UserDomain) -> Unit,
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = { onRefresh() },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                contentColor = KodeTheme.colors.contentActivePrimary
            )
        }
    ) {

        if (isRefreshing) {
            ShimmerUserList()
        } else {
            if (list.isEmpty()) {
                UsersNotFound(
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                UsersList(modifier, list, onListItemClick)
            }
        }
    }
}

/**
 * Preview of [RefreshingUsersList].
 */
@Preview(showBackground = true)
@Composable
fun PreviewRefreshingUsersList() {
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
        RefreshingUsersList(
            list = sourceList,
            onListItemClick = {},
            isRefreshing = false,
            onRefresh = {})
    }
}
