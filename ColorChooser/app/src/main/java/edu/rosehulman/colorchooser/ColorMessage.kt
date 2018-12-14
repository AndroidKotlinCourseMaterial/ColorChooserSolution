package edu.rosehulman.colorchooser

import android.graphics.Color

data class ColorMessage(
    var message: String = "This is your phone. Please rescue me!",
    var backgroundColor: Int = Color.GREEN
)