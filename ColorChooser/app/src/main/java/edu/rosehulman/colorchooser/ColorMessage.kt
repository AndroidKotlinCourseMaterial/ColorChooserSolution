package edu.rosehulman.colorchooser

import android.graphics.Color

data class ColorMessage(
    var message: String = "This is your phone. Please rescue me!",
    var backgroundColor: Int = Color.GREEN
) {
    companion object {
        val EXTRA_MESSAGE = "EXTRA_MESSAGE"
        val EXTRA_COLOR = "EXTRA_COLOR"
    }
}