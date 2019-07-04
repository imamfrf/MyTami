package com.infomedia.mytami.progress.reimbursement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infomedia.mytami.R
import com.infomedia.mytami.model.ReimbursementRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_reimbursement_progress.view.*

class ReimbursementProgressFragment : Fragment() {
    private lateinit var listItems: ArrayList<ReimbursementRequest>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_reimbursement_progress, null)



        listItems = arrayListOf()
        listItems.add(
            ReimbursementRequest(
                "TEL999999", "Meeting PT Telkom", "20 June 2019",
                "15 January 2019", "Jakarta", "Balikpapan", getString(R.string.reimbursement_status_0)
            )
        )

        view.recyclerV_reimbursement.apply {
            layoutManager = getReverseLinearLayoutManager()

            adapter = ReimbursementProgressAdapter(listItems, context,
                object : ReimbursementProgressAdapter.OnItemClicked {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                    }
                })
        }

        if (listItems.size > 0){
            activity?.bottom_navigation?.setNotification(listItems.size.toString(), 1)
        }
        return view
    }

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
    }
}
