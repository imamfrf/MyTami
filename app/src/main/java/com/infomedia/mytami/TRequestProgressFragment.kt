package com.infomedia.mytami

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_trequest_progress.view.*


class TRequestProgressFragment : Fragment() {

    private lateinit var listItems: ArrayList<TravelRequest>
    private lateinit var recyclerTravelRequest: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_trequest_progress, null)

        recyclerTravelRequest = view.recyclerV_tprogress


        listItems = arrayListOf()
        listItems.add(TravelRequest("TEL17774444", "Meeting Client BRI", "20 June 2019",
            "30 June 2019", "Jakarta", "Medan", getString(R.string.tprogress_status_0)))

        recyclerTravelRequest.apply {
            layoutManager = getReverseLinearLayoutManager()

            adapter = TRequestProgressAdapter(listItems, this@TRequestProgressFragment,
                object : TRequestProgressAdapter.OnItemClicked {
                    override fun onItemClick(position: Int){
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                    }
                })
        }
        return view
    }

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
    }


}
