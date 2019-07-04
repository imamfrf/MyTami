package com.infomedia.mytami.hotel_reservation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.model.Hotel
import kotlinx.android.synthetic.main.activity_hotel_reservation.*

class HotelReservationActivity : AppCompatActivity() {

    private lateinit var listItems: ArrayList<Hotel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_reservation)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val html = "<small>" + "<font color='#FFFFFF'>Jakarta: 01 July 2019, 2 Nights</font>" + "</small>"
        supportActionBar?.subtitle = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)

        listItems = arrayListOf()
        listItems.add(
            Hotel(
                "001", "Hotel Mulia Jakarta", 5.0f,
                "Sudirman, Jakarta Selatan", 950000.0, "http://www.asiadreams.com/wp-content/uploads/Hotel-Mulia-Senayan-Jakarta-Christmas-NY-1.jpg")
        )

        recyclerV_hotel_reservation.apply {
            layoutManager = getReverseLinearLayoutManager()

            adapter = HotelReservationAdapter(listItems, context,
                object : HotelReservationAdapter.OnItemClicked {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
//                        val intent = Intent(context, TravelRequestApprovalDetail::class.java)
//                        startActivity(intent)
                    }
                })
        }
    }

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, true)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
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
