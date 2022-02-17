package com.joma.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import java.util.*
import kotlin.collections.ArrayList


class Drawer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private var paint: Paint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
        style = Paint.Style.FILL
    }

    var xList: MutableList<Float> = ArrayList()
    var yList: MutableList<Float> = ArrayList()
    private lateinit var bitmap: Bitmap

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (x in xList.indices) {
            canvas?.drawCircle(xList[x], yList[x], 30f, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (MotionEvent.ACTION_DOWN == event?.action) {
            xList.add(event.x)
            yList.add(event.y)
            invalidate()
            return true
        }
        return false
    }

    fun generate(x: Int, y: Int): Bitmap {
        bitmap = Bitmap.createBitmap(x, y, Bitmap.Config.ARGB_8888)
        val rand = Random()

        for (i in 0 until x) {
            for (j in 0 until y) {
                // default color : Black
                var colorToPut = Color.BLACK

                // If lucky get a white pixel ;)
                if (rand.nextInt(2) == 0) {
                    colorToPut = Color.WHITE
                }

                // Set color to (i,j) pixel
                bitmap.setPixel(i, j, colorToPut)
            }
        }
        return bitmap
    }

//    fun draw(x: Int, y: Int) {
//        bitmap.setPixel(x/bitmap.width, y/bitmap.height, Color.RED)
//        setImageBitmap(bitmap)
//    }
}