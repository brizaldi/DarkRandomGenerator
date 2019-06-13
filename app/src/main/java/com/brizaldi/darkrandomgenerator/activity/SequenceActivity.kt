package com.brizaldi.darkrandomgenerator.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brizaldi.darkrandomgenerator.R

class SequenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequence)

        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
