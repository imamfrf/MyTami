package com.infomedia.mytami.travel_request

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.infomedia.mytami.R
import kotlinx.android.synthetic.main.activity_travel_request_travel_type.*

class TravelRequestTravelTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_request_travel_type)

        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.navigationIcon?.setColorFilter(resources.getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        button_next.setOnClickListener {
            val intent = Intent(this, TravelRequestTravelItineraryActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
