package com.joma.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ISetSize {

    private var width: Int = 100
    private var height: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mainSize.setOnClickListener {
            CustomDialog().showSize(this, this)
        }

        mainGenerate.setOnClickListener {
            val bit = mainFirstImage.generate(width, height)
            mainFirstImage.setImageBitmap(bit)
            mainSecondImage.setImageBitmap(bit)
        }

    }

    override fun size(width: Int, height: Int) {
        this.width = width
        this.height = height
    }
}