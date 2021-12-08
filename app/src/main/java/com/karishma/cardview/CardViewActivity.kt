package com.karishma.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .add(R.id.container, CardViewFragment2())
                .commit()
        }
    }
}