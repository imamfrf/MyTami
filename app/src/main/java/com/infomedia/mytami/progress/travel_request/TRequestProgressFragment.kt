package com.infomedia.mytami.progress.travel_request

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.approval.travel_request.TravelRequestApprovalDetail
import com.infomedia.mytami.model.TravelRequest
import com.infomedia.mytami.travel_request.TravelBookingActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_trequest_progress.view.*


class TRequestProgressFragment : Fragment() {

    private lateinit var listItems: ArrayList<TravelRequest>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_trequest_progress, null)




        listItems = arrayListOf()
        listItems.add(
            TravelRequest(
                "TEL17774444", "Meeting Client BRI", "20 June 2019",
                "30 June 2019", "Jakarta", "Medan", getString(R.string.tprogress_status_0)
            )
        )

        listItems.add(
            TravelRequest(
                "TEL17774444", "Meeting Client BRI", "20 June 2019",
                "30 June 2019", "Jakarta", "Medan", getString(R.string.tprogress_status_1)
            )
        )

        view.recyclerV_tprogress.apply {
            layoutManager = getReverseLinearLayoutManager() as RecyclerView.LayoutManager?

            adapter = TRequestProgressAdapter(listItems, context,
                object : TRequestProgressAdapter.OnItemClicked {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                        if (listItems[position].status == getString(R.string.tprogress_status_0)) {
                            val intent = Intent(context, TravelRequestApprovalDetail::class.java)
                            startActivity(intent)
                        } else if (listItems[position].status == getString(R.string.tprogress_status_1)) {
                            val intent = Intent(context, TravelBookingActivity::class.java)
                            startActivity(intent)
                        }
                    }
                })
        }

        if (listItems.size > 0) {
            activity?.bottom_navigation?.setNotification(" ", 1)
        }
        return view
    }

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
    }


}
