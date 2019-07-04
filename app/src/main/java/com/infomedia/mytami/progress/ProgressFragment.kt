package com.infomedia.mytami.progress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.infomedia.mytami.R
import com.infomedia.mytami.progress.reimbursement.ReimbursementProgressFragment
import com.infomedia.mytami.progress.travel_request.TRequestProgressFragment


class ProgressFragment : Fragment() {
    private var adapter: TabAdapter? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_progress, null)

        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        adapter = TabAdapter(activity!!.supportFragmentManager)
        adapter!!.addFragment(TRequestProgressFragment(), "Travel Request")
        adapter!!.addFragment(ReimbursementProgressFragment(), "Reimbursement")

        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)
        return view
    }
}
