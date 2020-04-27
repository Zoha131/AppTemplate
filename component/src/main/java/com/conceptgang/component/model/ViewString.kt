package com.conceptgang.component.model

import android.content.Context
import androidx.annotation.StringRes
import java.security.InvalidParameterException

class ViewString private constructor(
    private val data: String? = null,
    @StringRes private val dataInt: Int = -1
){

    constructor(data: String): this(data, -1)
    constructor(@StringRes dataInt: Int): this(null, dataInt)

    init {
        if(data == null && dataInt == -1) throw InvalidParameterException("You must have to pass either string or string resource not both")
        else if (data != null && dataInt != -1) throw InvalidParameterException("You must have to pass either string or string resource not both")
    }

    fun getValue(context: Context): String =  data ?: context.getString(dataInt)

}

fun String.toViewString() = ViewString(this)
fun @receiver:StringRes Int.toViewString() = ViewString(this)
