package com.zenmo.web.zenmo.utils

import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingTop

fun Modifier.paddingVertical(
    value: CSSLengthOrPercentageNumericValue,
): Modifier = styleModifier {
    paddingTop(value)
    paddingBottom(value)
}
