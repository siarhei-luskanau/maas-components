package com.trafi.ui.theme.internal

import platform.UIKit.*

actual typealias OsTextStyle = UIFont

internal actual fun OsTextStyle.copy(
    fontStyle: BasicFontStyle?,
    fontWeight: BasicFontWeight?,
    fontSize: Int?,
    lineHeight: Int?,
): OsTextStyle {
    var descriptor = this.fontDescriptor
    if (fontStyle?.os != null) {
        descriptor = descriptor.fontDescriptorWithSymbolicTraits(fontStyle.os!!) ?: descriptor
    }
    if (fontWeight != null) {
        descriptor = descriptor.fontDescriptorByAddingAttributes(
            mapOf(UIFontDescriptorTraitsAttribute to mapOf(UIFontWeightTrait to fontWeight.os))
        )
    }
    if (lineHeight != null) {
        // TODO: No way to add line height to UIFont :(
    }
    return UIFont.fontWithDescriptor(descriptor,fontSize?.os ?: this.pointSize)
}

internal actual fun OsTextStyle(
    fontStyle: BasicFontStyle,
    fontWeight: BasicFontWeight,
    fontSize: Int,
    lineHeight: Int,
): OsTextStyle = UIFont.systemFontOfSize(fontSize.os).copy(fontStyle, fontWeight, lineHeight)

private val BasicFontStyle.os get() = when (this) {
    BasicFontStyle.Normal -> null
    BasicFontStyle.Italic -> UIFontDescriptorTraitItalic
}

private val BasicFontWeight.os get() = when (this) {
    BasicFontWeight.Normal -> UIFontWeightRegular
    BasicFontWeight.SemiBold -> UIFontWeightSemibold
    BasicFontWeight.Bold -> UIFontWeightBold
}

private val Int.os get() = this.toDouble()
