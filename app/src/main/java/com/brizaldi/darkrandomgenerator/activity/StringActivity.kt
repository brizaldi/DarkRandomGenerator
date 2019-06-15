package com.brizaldi.darkrandomgenerator.activity

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brizaldi.darkrandomgenerator.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_string.*

class StringActivity : AppCompatActivity() {

    private var clipboardManager: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

        buttonRandomize.setOnClickListener {
            val total = editTextTotal.text.toString()
            val size = editTextLong.text.toString()

            if (total.trim().isNotEmpty() && size.trim().isNotEmpty()) {
                if (checkBoxNumeric.isChecked || checkBoxUppercase.isChecked || checkBoxLowercase.isChecked) {
                    randomize(
                        total.toInt(),
                        size.toInt()
                    )
                }
                else {
                    Snackbar.make(rootView, resources.getString(R.string.text_string_snack_checkbox_empty),
                        Snackbar.LENGTH_LONG).show()
                }
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

    private fun randomize(total: Int, size: Int) {
        var result = "Result :"

        var charPool : List<Char> = listOf()

        if (checkBoxNumeric.isChecked)
            charPool = charPool + ('0'..'9')
        if (checkBoxUppercase.isChecked)
            charPool = charPool + ('A'..'Z')
        if (checkBoxLowercase.isChecked)
            charPool = charPool + ('a'..'z')

        for (i in 1..total) {
            val rnd = (1..size)
                .map { kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")

            result +=  "\n$rnd"
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
