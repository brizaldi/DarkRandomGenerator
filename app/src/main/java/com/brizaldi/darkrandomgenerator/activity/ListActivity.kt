package com.brizaldi.darkrandomgenerator.activity

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brizaldi.darkrandomgenerator.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private var clipboardManager: ClipboardManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?

        buttonRandomize.setOnClickListener {
            val listData = editTextList.text.toString()

            if (listData.trim().isNotEmpty()) {
                randomize(listData)
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

    private fun randomize(string: String) {
        var result = "Result :"

        val lines = string.split("\n").toMutableList()
        lines.shuffle()

        lines.forEach {
            result +=  "\n$it"
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