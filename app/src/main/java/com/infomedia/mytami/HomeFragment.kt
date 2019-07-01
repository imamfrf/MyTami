package com.infomedia.mytami

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infomedia.mytami.reimbursement.ReimbursementTravelTypeActivity
import com.infomedia.mytami.travel_request.TravelRequestTravelTypeActivity
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_home, null)

        view.cardview_travel_request.setOnClickListener {
            val intent = Intent(context, TravelRequestTravelTypeActivity::class.java)
            startActivity(intent)
        }

        view.cardview_reimbursement.setOnClickListener {
            val intent = Intent(context, ReimbursementTravelTypeActivity::class.java)
            startActivity(intent)
        }

        view.cardview_travel_request_approval.setOnClickListener {
            val intent = Intent(context, TravelRequestApprovalActivity::class.java)
            startActivity(intent)
        }

        view.cardview_travel_cancel_approval.setOnClickListener {
            val intent = Intent(context, TravelCancelApprovalActivity::class.java)
            startActivity(intent)
        }

        view.cardview_reimbursement_approval.setOnClickListener {
            val intent = Intent(context, ReimbursementApprovalActivity::class.java)
            startActivity(intent)
        }


        return view
    }


}
