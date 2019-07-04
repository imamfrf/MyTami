package com.infomedia.mytami.approval.travel_request

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.model.TravelRequest

class TRequestApprovalAdapter(private val listItems: List<TravelRequest>, private val context: Context,
                              private val mListener: OnItemClicked
)
    : RecyclerView.Adapter<TRequestApprovalAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_approval, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvRequestId?.text = item.id+"-"+item.title
        holder.tvRequestDate?.text = "Request date : "+item.requestDate
        holder.tvTravelDate?.text = "Travel date : "+item.travelDate
        holder.tvDestination?.text = item.origin+"-"+item.destination
        holder.cardView?.setOnClickListener{
            mListener.onItemClick(position)
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // MARK: - Public Properties
        val cardView: CardView? = itemView?.findViewById(R.id.cardview_approval)
        val tvRequestId: TextView? = itemView?.findViewById(R.id.tv_request_id_approval)
        val tvRequestDate: TextView? = itemView?.findViewById(R.id.tv_prequest_date_approval)
        val tvTravelDate: TextView? = itemView?.findViewById(R.id.tv_travel_date_approval)
        val tvDestination: TextView? = itemView?.findViewById(R.id.tv_destination_approval)

    }

    interface OnItemClicked {
        fun onItemClick(position: Int)
    }
}