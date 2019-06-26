package com.infomedia.mytami

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView



class ReimbursementProgressAdapter(private val listItems: List<ReimbursementRequest>, private val context: ReimbursementProgressFragment,
                              private val mListener: OnItemClicked)
    : RecyclerView.Adapter<ReimbursementProgressAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_progress, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]
        holder.tvRequestId?.text = item.id+"-"+item.title
        holder.tvRequestDate?.text = item.requestDate
        holder.tvTravelDate?.text = item.travelDate
        holder.tvDestination?.text = item.origin+"-"+item.destination
        holder.tvRequestStatus?.text = item.status
        holder.layoutStatus?.background = ContextCompat.getDrawable(context.requireContext(),
            R.drawable.rounded_corner_reimbursement_status_0)

        holder.cardView?.setOnClickListener{
            mListener.onItemClick(position)
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // MARK: - Public Properties
        val cardView: CardView? = itemView?.findViewById(R.id.cardview_progress)
        val tvRequestId: TextView? = itemView?.findViewById(R.id.tv_request_id_approval)
        val tvRequestDate: TextView? = itemView?.findViewById(R.id.tv_prequest_date_approval)
        val tvTravelDate: TextView? = itemView?.findViewById(R.id.tv_travel_date_approval)
        val tvDestination: TextView? = itemView?.findViewById(R.id.tv_destination_approval)
        val tvRequestStatus: TextView? = itemView?.findViewById(R.id.tv_progress_status)
        val layoutStatus: ConstraintLayout? = itemView?.findViewById(R.id.layout_progress_status)

    }

    interface OnItemClicked {
        fun onItemClick(position: Int)
    }
}

