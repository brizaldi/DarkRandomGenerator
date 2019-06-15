package com.brizaldi.darkrandomgenerator.activity

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brizaldi.darkrandomgenerator.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_integer.*

class IntegerActivity : AppCompatActivity() {

    private var clipboardManager: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_integer)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

        buttonRandomize.setOnClickListener {
            val min = editTextMin.text.toString()
            val max = editTextMax.text.toString()
            val total = editTextTotal.text.toString()

            if (min.trim().isNotEmpty() && max.trim().isNotEmpty() && total.trim().isNotEmpty()) {
                randomize(
                    min.toInt(),
                    max.toInt(),
                    total.toInt()
                )
            }
            else {
                Snackbar.make(rootView, resources.getString(R.string.text_main_snack_empty),
                    Snackbar.LENGTH_LONG).show()
            }
        }

        buttonCopy.setOnClickListener {
            copyToClipboard()
        }
    }

    private fun randomize(min: Int, max: Int, total: Int) {
        var result = "Result :"

        for (i in 1..total) {
            val rnd = (min..max).random()
            result +=  " $rnd"
        }

        textViewResult.text = result

        cardViewResult.visibility = View.VISIBLE
    }

    private fun copyToClipboard() {
        val clipboard = ClipData.newPlainText("random", textViewResult.text)
        clipboardManager?.primaryClip = clipboard

        Snackbar.make(rootView, resources.getString(R.string.text_main_copy),
            Snackbar.LENGTH_LONG).show()
    }
}
