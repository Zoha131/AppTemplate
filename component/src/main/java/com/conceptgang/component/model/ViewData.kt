package com.conceptgang.component.model

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import java.security.InvalidParameterException


typealias ZHViewCallback = (Int, ViewData)->Unit


sealed class ViewData {

}