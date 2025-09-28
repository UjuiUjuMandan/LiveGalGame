package com.example.livegg1

import android.graphics.Bitmap

fun cropBitmapToAspectRatio(bitmap: Bitmap, aspectRatio: Float): Bitmap {
    val originalWidth = bitmap.width
    val originalHeight = bitmap.height
    val originalAspectRatio = originalWidth.toFloat() / originalHeight.toFloat()

    return if (originalAspectRatio > aspectRatio) {
        // Original image is wider than the target aspect ratio (crop width)
        val targetWidth = (originalHeight * aspectRatio).toInt()
        val x = (originalWidth - targetWidth) / 2
        Bitmap.createBitmap(bitmap, x, 0, targetWidth, originalHeight)
    } else {
        // Original image is taller than or equal to the target aspect ratio (crop height)
        val targetHeight = (originalWidth / aspectRatio).toInt()
        val y = (originalHeight - targetHeight) / 2
        Bitmap.createBitmap(bitmap, 0, y, originalWidth, targetHeight)
    }
}
