package com.infomedia.mytami.reimbursement

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.CheckBox
import com.infomedia.mytami.R
import kotlinx.android.synthetic.main.activity_travel_request_travel_itinerary.*
import kotlinx.android.synthetic.main.content_others.*
import kotlinx.android.synthetic.main.content_trip_information.*

class ReimbursementTravelItineraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reimbursement_travel_itinerary)

        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.navigationIcon?.setColorFilter(resources.getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP)

        button_submit.setOnClickListener {
            val intent = Intent(this, ReimbursementTravelDescriptionActivity::class.java)
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

    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.check_box_departure -> {
                    if (checked) {
                        fadeInAnimation(text_input_layout_reason_departure)
                    } else {
                        text_input_layout_reason_departure.visibility = View.GONE
                    }
                }
                R.id.check_box_return -> {
                    if (checked) {
                        fadeInAnimation(text_input_layout_reason_return)
                    } else {
                        text_input_layout_reason_return.visibility = View.GONE
                    }
                }
                R.id.check_box_cost_center -> {
                    if (checked) {
                        fadeInAnimation(text_input_layout_cost_center)
                    } else {
                        text_input_layout_cost_center.visibility = View.GONE
                    }
                }
                R.id.check_box_diskresi -> {
                    if (checked) {
                        fadeInAnimation(text_input_layout_diskresi_type)
                        fadeInAnimation(text_input_layout_diskresi_reason)
                    } else {
                        text_input_layout_diskresi_type.visibility = View.GONE
                        text_input_layout_diskresi_reason.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun fadeInAnimation(view: View) {
        val animate = AlphaAnimation(0.0f, 1.0f)
        animate.duration = 500
        view.startAnimation(animate)
        view.visibility = View.VISIBLE
    }
}
