package com.infomedia.mytami.flight_reservation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.model.FlightOutbound

class FlightConfirmationAdapter(private val items: ArrayList<FlightOutbound>) :
    RecyclerView.Adapter<FlightConfirmationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight_detail, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.airline.text = item.airline
        holder.flightNumber.text = item.flightNumber
        holder.departureCity.text = item.departureCity
        holder.departureAirport.text = item.departureAirport
        holder.departureTime.text = item.departureTime
        holder.arrivalCity.text = item.arrivalCity
        holder.arrivalAirport.text = item.arrivalAirport
        holder.arrivalTime.text = item.arrivalTime
        holder.transitInformation.text = item.transitInformation
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // MARK: - Public Properties
        val airline: TextView
        val flightNumber: TextView
        val departureCity: TextView
        val departureAirport: TextView
        val departureTime: TextView
        val arrivalCity: TextView
        val arrivalAirport: TextView
        val arrivalTime: TextView
        val transitInformation: TextView

        // MARK: - Initialization
        init {
            airline = itemView?.findViewById(R.id.text_view_airline) as TextView
            flightNumber = itemView.findViewById(R.id.text_view_flight_number) as TextView
            departureCity = itemView.findViewById(R.id.text_view_departure_city) as TextView
            departureAirport = itemView.findViewById(R.id.text_view_departure_airport) as TextView
            departureTime = itemView.findViewById(R.id.text_view_departure_time) as TextView
            arrivalCity = itemView.findViewById(R.id.text_view_arrival_city) as TextView
            arrivalAirport = itemView.findViewById(R.id.text_view_arrival_airport) as TextView
            arrivalTime = itemView.findViewById(R.id.text_view_arrival_time) as TextView
            transitInformation = itemView.findViewById(R.id.text_view_transit_information) as TextView
        }
    }
}