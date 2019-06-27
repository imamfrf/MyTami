package com.infomedia.mytami

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_home, null)

        view.cardview_travel_request.setOnClickListener {
            val intent = Intent(context, TravelRequestTravelTypeActivity::class.java)
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
