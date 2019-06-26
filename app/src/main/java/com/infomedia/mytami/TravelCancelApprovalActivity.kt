package com.infomedia.mytami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_travel_cancel_approval.*
import kotlinx.android.synthetic.main.activity_travel_request_approval.*

class TravelCancelApprovalActivity : AppCompatActivity() {

    private lateinit var listItems: ArrayList<TravelRequest>
    private lateinit var recyclerTravelCancelApproval: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_cancel_approval)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerTravelCancelApproval = recyclerV_tcancel_approval



        listItems = arrayListOf()
        listItems.add(TravelRequest("TEL17774444", "Meeting Client BRI", "20 June 2019",
            "30 June 2019", "Jakarta", "Medan", getString(R.string.tprogress_status_0)))

        recyclerTravelCancelApproval.apply {
            layoutManager = getReverseLinearLayoutManager()

            adapter = TRequestApprovalAdapter(listItems, this@TravelCancelApprovalActivity,
                object : TRequestApprovalAdapter.OnItemClicked {
                    override fun onItemClick(position: Int){
                        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                        val intent = Intent(context, TravelRequestApprovalDetail::class.java)
                        startActivity(intent)
                    }
                })
        }

    }

    private fun getReverseLinearLayoutManager(): LinearLayoutManager {
        val reverseLinearLayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, true)
        reverseLinearLayoutManager.stackFromEnd = true
        return reverseLinearLayoutManager
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    }

