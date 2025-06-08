package com.example.pohozhe.DataProcessing.uiData

import com.example.pohozhe.R
import java.util.Locale

fun getLocalizedDegreesText(locale: Locale, degrees: Int): Int {
    return when (locale.language) {
        "uk" -> getDegreesUkr(degrees)
        "en" -> getDegreesEng(degrees)
        else -> getDegreesEng(degrees)
    }
}

fun getDegreesUkr(degrees: Int): Int {
    return when {
        degrees % 10 == 1 && degrees % 100 != 11 ->  R.string.DegreeUKs
        degrees % 10 in 2..4 && (degrees % 100 !in 12..14) -> R.string.DegreeUKsy
        else -> R.string.DegreeUKsiv
    }
}

fun getDegreesEng(degrees: Int): Int {
    return when {
        degrees == 1 -> R.string.DegreeEN
        else -> R.string.DegreesEN
    }
}
