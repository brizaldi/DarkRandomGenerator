package com.brizaldi.darkrandomgenerator.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brizaldi.darkrandomgenerator.R

class StringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string)

        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
