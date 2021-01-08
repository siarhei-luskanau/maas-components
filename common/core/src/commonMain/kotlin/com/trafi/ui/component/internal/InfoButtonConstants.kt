package com.trafi.ui.component.internal

import com.trafi.ui.theme.internal.*
import com.trafi.ui.theme.internal.BasicFontWeight.*
import com.trafi.ui.theme.internal.copy

class InfoButtonConstants(theme: CurrentTheme) {
    val iconWidth = 16.dp
    val iconHeight = 16.dp

    val paddingVertical = SpacingScale.md
    val paddingHorizontal = SpacingScale.sm
    val spaceBetween = SpacingScale.xs

    val maxLinesCount = 1

    val textStyle = theme.typographyScale.textL.copy(fontWeight = Bold)
    val cornerRadius = theme.cornerRadiusScale.buttonRadius

    val defaultContentColor = theme.colorPalette.onSurface
    val disabledContentColor = defaultContentColor.alpha(0.38f)

    val highlightedGradient = Gradient(
        direction = Gradient.Direction.Horizontal,
        colors = listOf(
            theme.colorPalette.grayScale.gray300.alpha(0f),
            theme.colorPalette.grayScale.gray300,
            theme.colorPalette.grayScale.gray300.alpha(0f),
        )
    )
}
