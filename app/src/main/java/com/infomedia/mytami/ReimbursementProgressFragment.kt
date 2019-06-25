package com.infomedia.mytami

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_reimbursement_progress.view.*
import kotlinx.android.synthetic.main.fragment_trequest_progress.view.*

class ReimbursementProgressFragment : Fragment() {
    private lateinit var listItems: ArrayList<ReimbursementRequest>
    private lateinit var recyclerReimbursement: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_reimbursement_progress, null)

        recyclerReimbursement = view.recyclerV_reimbursement


        listItems = arrayListOf()
        listItems.add(ReimbursementRequest("TEL999999", "Meeting PT Telkom", "20 June 2019",
            "15 January 2019", "Jakarta", "Balikpapan", getString(R.string.reimbursement_status_0)))

        recyclerReimbursement.apply {
            layoutManager = getReverseLinearLayoutManager()

            adapter = ReimbursementProgressAdapter(listItems, this@ReimbursementProgressFragment,
                object : ReimbursementProgressAdapter.OnItemClicked {
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
