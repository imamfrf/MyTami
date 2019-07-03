package com.infomedia.mytami.flight_reservation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.model.FlightOutbound
import kotlinx.android.synthetic.main.content_flight_information.*

class FlightConfirmationActivity : AppCompatActivity() {

    private var mFlightOutbounds = arrayListOf<FlightOutbound>()
    private var mAdapter: FlightConfirmationAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_confirmation)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mFlightOutbounds.add(
            FlightOutbound(
                "Garuda Indonesia ",
                "GA-123",
                "Medan (KNO)",
                "Kualanamu International Airport",
                "10:00, 20 Jul 2019",
                "Jakarta(CGK)",
                "Soekarno-Hatta International Airport",
                "12:00, 20 Jul 2019",
                "Connection time 1h 15m"
            )
        )
        mFlightOutbounds.add(
            FlightOutbound(
                "Garuda Indonesia ",
                "GA-123",
                "Jakarta(CGK)",
                "Soekarno-Hatta International Airport",
                "13:00, 20 Jul 2019",
                "Denpasar (DPS)",
                "Ngurah Rai International Airport",
                "14:00, 20 Jul 2019",
                ""
            )
        )

        setupRecyclerView()
    }

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
    }

    private fun setupRecyclerView() {
        recycler_view.layoutManager = getReverseLinearLayoutManager()
        mAdapter = FlightConfirmationAdapter(mFlightOutbounds)
        recycler_view.adapter = mAdapter
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
