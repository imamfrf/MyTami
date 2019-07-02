package com.infomedia.mytami

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infomedia.mytami.api.SharedPrefManager
import com.infomedia.mytami.model.User
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_profile, null)
        val user = SharedPrefManager(context!!).getInstance(context!!).getUser()

        Log.d("TES", user.username)
        view.tv_profile_name.text = user.username
        view.tv_profile_id.text = user.nik
        view.tv_profile_level.text = user.userLevel

        view.btn_logout.setOnClickListener {
            SharedPrefManager(context!!).getInstance(context!!).logout()
            activity!!.finish()
        }


        return view
    }
}
