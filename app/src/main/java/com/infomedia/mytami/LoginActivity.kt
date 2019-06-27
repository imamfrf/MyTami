package com.infomedia.mytami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var spinnerCorporate: Spinner
    lateinit var spinnerLevel: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        spinnerCorporate = findViewById(R.id.spinner_corporate)
        ArrayAdapter.createFromResource(
            this,
            R.array.corporates_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinnerCorporate.adapter = adapter
        }

        spinnerLevel = findViewById(R.id.spinner_level)
        ArrayAdapter.createFromResource(
            this,
            R.array.levels_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            spinnerLevel.adapter = adapter
        }

        button_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
