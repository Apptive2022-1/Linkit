package com.example.linkit.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ModeEdit
import androidx.compose.material.icons.filled.Wallpaper
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.linkit._constant.UIConstants

@Composable
fun AppBottomBarEditFolder(
    text: String
) {
    AppBottomBarEdit(
        text = text,
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            IconTextButtonVert(
                icon = Icons.Filled.Delete,
                iconSize = UIConstants.ICON_SIZE_BOTTOM_HOVER,
                text = "삭제"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            IconTextButtonVert(
                icon = Icons.Filled.ModeEdit,
                iconSize = UIConstants.ICON_SIZE_BOTTOM_HOVER,
                text = "이름변경"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            IconTextButtonVert(
                icon = Icons.Filled.Wallpaper,
                iconSize = UIConstants.ICON_SIZE_BOTTOM_HOVER,
                text = "사진변경"
            )
        }
    }
}