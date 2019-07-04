package com.infomedia.mytami.hotel_reservation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infomedia.mytami.R
import com.infomedia.mytami.model.Hotel
import java.text.DecimalFormat

class HotelReservationAdapter(private val listItems: List<Hotel>, private val context: Context,
                                   private val mListener: OnItemClicked
)
    : RecyclerView.Adapter<HotelReservationAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hotel, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvHotelName?.text = item.name
        holder.tvHotelAddress?.text = item.address
        holder.ratingBarHotel?.rating = item.stars!!
        holder.ratingBarHotel?.numStars = item.stars!!.toInt()
        val formatter = DecimalFormat("#,###")
        holder.tvLowestPrice?.text = context.getString(R.string.hotel_lowest_price_item,
            formatter.format(item.lowestPrice))

        Glide.with(context).load(item.image).into(holder.imgHotel!!)

        holder.cardView?.setOnClickListener{
            mListener.onItemClick(position)
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // MARK: - Public Properties
        val cardView: CardView? = itemView?.findViewById(R.id.cardview_hotel)
        val tvHotelName: TextView? = itemView?.findViewById(R.id.tv_hotel_name_item)
        val ratingBarHotel: RatingBar? = itemView?.findViewById(R.id.ratingBar_hotel_item)
        val tvHotelAddress: TextView? = itemView?.findViewById(R.id.tv_hotel_address_item)
        val tvLowestPrice: TextView? = itemView?.findViewById(R.id.tv_hotel_lowest_price)
        val imgHotel: ImageView? = itemView?.findViewById(R.id.img_hotel_item)

    }

    interface OnItemClicked {
        fun onItemClick(position: Int)
    }
}