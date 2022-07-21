package com.mityushovn.kodetestproject.ui.screens.main.userslist

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.kodetestproject.ui.theme.KodeTheme
import com.valentinilk.shimmer.LocalShimmerTheme
import com.valentinilk.shimmer.defaultShimmerTheme
import com.valentinilk.shimmer.shimmer

private val shimmerUserListTheme = defaultShimmerTheme.copy(
    animationSpec = infiniteRepeatable(
        animation = tween(
            durationMillis = 1400,
            delayMillis = 300,
            easing = LinearEasing,
        ),
    ),
    blendMode = BlendMode.Multiply,
    rotation = 25f,
    shaderColors = listOf(
        Color.White.copy(alpha = 0.6f),
        Color.White.copy(alpha = 0.0f),
        Color.White.copy(alpha = 0.6f),
    ),
    shaderColorStops = null,
    shimmerWidth = 400.dp,
)

@Composable
fun ShimmerUserList(
    modifier: Modifier = Modifier,
    size: Int = 10
) {
    CompositionLocalProvider(
        LocalShimmerTheme provides shimmerUserListTheme,
    ) {
        Column(modifier = modifier) {
            Spacer(modifier = Modifier.heightIn(24.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            ) {
                repeat((0..size).count()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shimmer()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(CircleShape)
                                    .background(color = KodeTheme.colors.skeletonGradient0)
                            ) {}

                            Spacer(modifier = Modifier.width(16.dp))

                            Column(verticalArrangement = Arrangement.Center) {
                                Box(
                                    modifier = Modifier
                                        .size(width = 144.dp, height = 16.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(color = KodeTheme.colors.skeletonGradient0)
                                ) {}
                                Spacer(modifier = Modifier.heightIn(6.dp))
                                Box(
                                    modifier = Modifier
                                        .size(width = 80.dp, height = 12.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(color = KodeTheme.colors.skeletonGradient0)
                                ) {}
                            }
                        }
                    }
                    Spacer(modifier = Modifier.heightIn(24.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShimmerUserList() {
    KodeTheme {
        ShimmerUserList()
    }
}
