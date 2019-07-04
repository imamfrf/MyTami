package com.infomedia.mytami.flight_reservation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.extension.toast
import com.infomedia.mytami.model.Flight
import kotlinx.android.synthetic.main.activity_flight_reservation.*

class FlightReservationActivity : AppCompatActivity(),
    FlightReservationListener {

    private var mFlights = arrayListOf<Flight>()
    private var mAdapter: FlightReservationAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_reservation)

        val html = "<small>" + "<font color='#FFFFFF'>Jakarta - Surabaya: Mon, 01 July 2019</font>" + "</small>"
        supportActionBar?.subtitle = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mFlights.add(
            Flight(
                "QZ-123", "Air Asia", "IDR1,500,000", "10:00", "12:00",
                "CGK", "SUB", "1h 45m", "Direct"
            )
        )
        mFlights.add(
            Flight(
                "QZ-123", "Air Asia", "IDR1,500,000", "10:00", "12:00",
                "CGK", "SUB", "1h 45m", "Direct"
            )
        )
        mFlights.add(
            Flight(
                "QZ-123", "Air Asia", "IDR1,500,000", "10:00", "12:00",
                "CGK", "SUB", "1h 45m", "Direct"
            )
        )
        mFlights.add(
            Flight(
                "QZ-123", "Air Asia", "IDR1,500,000", "10:00", "12:00",
                "CGK", "SUB", "1h 45m", "Direct"
            )
        )
        mFlights.add(
            Flight(
                "QZ-123", "Air Asia", "IDR1,500,000", "10:00", "12:00",
                "CGK", "SUB", "1h 45m", "Direct"
            )
        )

        setupRecyclerView()
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

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, true)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
    }

    private fun setupRecyclerView() {
        recycler_view.layoutManager = getReverseLinearLayoutManager()
        mAdapter = FlightReservationAdapter(mFlights, this)
        recycler_view.adapter = mAdapter
    }

    override fun onItemClick(id: String) {
        toast("item clicked:$id")
    }

}
