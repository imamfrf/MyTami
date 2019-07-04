package com.infomedia.mytami.travel_request

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.infomedia.mytami.R
import kotlinx.android.synthetic.main.activity_travel_request_travel_description.*
import kotlinx.android.synthetic.main.content_cost_detail.*
import kotlinx.android.synthetic.main.content_trip_detail.*
import net.cachapa.expandablelayout.ExpandableLayout.OnExpansionUpdateListener


class TravelRequestTravelDescriptionActivity : AppCompatActivity() {

    private var mRotationAngle: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_request_travel_description)

        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.navigationIcon?.setColorFilter(resources.getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        expandable_layout.setOnExpansionUpdateListener(object : OnExpansionUpdateListener {
            override fun onExpansionUpdate(expansionFraction: Float, state: Int) {
                Log.d("ExpandableLayout0", "State: $state")
            }
        })

        expand_button.setOnClickListener {
            if (expandable_layout.isExpanded) {
                expandable_layout.collapse()
            } else {
                expandable_layout.expand()
            }
            mRotationAngle = if (mRotationAngle == 0) 180 else 0
            image_view_expand_arrow.animate().rotation(mRotationAngle.toFloat()).setDuration(500).start()
        }

        text_view_departure_city.isSelected = true
        text_view_arrival_city.isSelected = true
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
