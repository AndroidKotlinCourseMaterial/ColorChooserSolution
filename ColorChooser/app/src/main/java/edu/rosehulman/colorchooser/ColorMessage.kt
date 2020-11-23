package edu.rosehulman.colorchooser

import android.graphics.Color
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ColorMessage(
    var message: String = "This is your phone. Please rescue me!",
    var backgroundColor: Int = Color.GREEN
): Parcelable {
    companion object {
        val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        val EXTRA_COLOR = "EXTRA_COLOR"
    }
}