package com.infomedia.mytami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TravelRequestTravelTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_request_travel_type)
        setSupportActionBar(findViewById(R.id.toolbar))
//        supportActionBar?.setDisplayShowTitleEnabled(true)
    }
}
