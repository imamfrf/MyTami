package com.infomedia.mytami.flight_reservation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.model.Flight

class FlightReservationAdapter(private val items: ArrayList<Flight>, private val listener: FlightReservationListener) :
    RecyclerView.Adapter<FlightReservationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.cardView.setOnClickListener {
            listener.onItemClick(item.flightNumber!!)
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // MARK: - Public Properties
        val cardView: CardView
        val flightNumber: TextView
        val airline: TextView
        val price: TextView
        val departureTime: TextView
        val arrivalTime: TextView
        val departureAirport: TextView
        val arrivalAirport: TextView
        val estimatedTime: TextView
        val transitInformation: TextView

        // MARK: - Initialization
        init {
            cardView = itemView?.findViewById(R.id.card_view) as CardView
            flightNumber = itemView.findViewById(R.id.text_view_flight_number) as TextView
            airline = itemView.findViewById(R.id.text_view_airline) as TextView
            price = itemView.findViewById(R.id.text_view_price) as TextView
            departureTime = itemView.findViewById(R.id.text_view_departure_time) as TextView
            arrivalTime = itemView.findViewById(R.id.text_view_arrival_time) as TextView
            departureAirport = itemView.findViewById(R.id.text_view_departure_airport) as TextView
            arrivalAirport = itemView.findViewById(R.id.text_view_arrival_airport) as TextView
            estimatedTime = itemView.findViewById(R.id.text_view_estimated_time) as TextView
            transitInformation = itemView.findViewById(R.id.text_view_transit_information) as TextView
        }
    }
}