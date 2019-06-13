package com.brizaldi.darkrandomgenerator.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brizaldi.darkrandomgenerator.R

class CoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)

        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
