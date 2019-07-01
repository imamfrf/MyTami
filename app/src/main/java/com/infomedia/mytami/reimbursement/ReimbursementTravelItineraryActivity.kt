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
import com.infomedia.mytami.travel_request.TravelRequestTravelDescriptionActivity
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

        button_next.setOnClickListener {
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
                R.id.checkBox_departure -> {
                    if (checked) {
                        fadeInAnimation(textInputLayout_reason_departure)
                    } else {
                        textInputLayout_reason_departure.visibility = View.GONE
                    }
                }
                R.id.checkBox_return -> {
                    if (checked) {
                        fadeInAnimation(textInputLayout_reason_return)
                    } else {
                        textInputLayout_reason_return.visibility = View.GONE
                    }
                }
                R.id.checkBox_cost_center -> {
                    if (checked) {
                        fadeInAnimation(textInputLayout_cost_center)
                    } else {
                        textInputLayout_cost_center.visibility = View.GONE
                    }
                }
                R.id.checkBox_diskresi -> {
                    if (checked) {
                        fadeInAnimation(textInputLayout_diskresi_type)
                        fadeInAnimation(textInputLayout_diskresi_reason)
                    } else {
                        textInputLayout_diskresi_type.visibility = View.GONE
                        textInputLayout_diskresi_reason.visibility = View.GONE
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
