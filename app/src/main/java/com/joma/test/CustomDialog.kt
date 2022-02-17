package com.joma.test

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CustomDialog {
    fun showSize(context: Context, sizeListener: ISetSize) {
        val dialog = Dialog(context)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_size)
        dialog.show()
        val width = dialog.findViewById<EditText>(R.id.dialogWidth)
        val height = dialog.findViewById<EditText>(R.id.dialogHeight)
        val cancel = dialog.findViewById<Button>(R.id.dialogCancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        val set = dialog.findViewById<Button>(R.id.dialogOk)
        set.setOnClickListener {
            if (width.text.isBlank() || height.text.isBlank()) {
                Toast.makeText(context, "Fill both fields", Toast.LENGTH_LONG).show()
            } else if (width.text.toString().toInt() < 1 || height.text.toString().toInt() < 1) {
                Toast.makeText(context, "Positive numbers only", Toast.LENGTH_LONG).show()
            } else {
                sizeListener.size(width.text.toString().toInt(), height.text.toString().toInt())
                dialog.dismiss()
            }
        }
    }
}