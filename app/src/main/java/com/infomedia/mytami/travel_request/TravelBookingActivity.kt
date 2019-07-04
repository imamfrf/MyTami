package com.infomedia.mytami.travel_request

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infomedia.mytami.R
import com.infomedia.mytami.flight_reservation.FlightReservationActivity
import kotlinx.android.synthetic.main.content_flight_hotel_reservation.*

class TravelBookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_booking)

        button_booking_flight.setOnClickListener {
            val intent = Intent(this, FlightReservationActivity::class.java)
            startActivity(intent)
        }
    }


}
