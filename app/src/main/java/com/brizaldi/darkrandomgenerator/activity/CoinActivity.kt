package com.brizaldi.darkrandomgenerator.activity

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brizaldi.darkrandomgenerator.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_coin.*

class CoinActivity : AppCompatActivity() {

    private var clipboardManager: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

        buttonRandomize.setOnClickListener {
            val total = editTextTotal.text.toString()

            if (total.trim().isNotEmpty()) {
                randomize(
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

    private fun randomize(total: Int) {
        var result = "Result :"

        for (i in 1..total) {
            val rnd = (0..1).random()
            result += if (rnd == 0) {
                " heads"
            } else {
                " tails"
            }
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
