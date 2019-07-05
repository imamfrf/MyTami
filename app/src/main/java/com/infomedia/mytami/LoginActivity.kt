package com.infomedia.mytami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_login.*
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject
import android.os.AsyncTask
import com.infomedia.mytami.api.SharedPrefManager
import com.infomedia.mytami.model.User
import com.infomedia.mytami.api.RequestHandler
import java.util.*


class LoginActivity : AppCompatActivity() {

    lateinit var spinnerCorporate: Spinner
    lateinit var spinnerLevel: Spinner

    private lateinit var username: String
    private lateinit var password: String
    private lateinit var corporate: String
    private lateinit var level: String
    private val loginUrl = "http://b46a3f89.ngrok.io/mytami/api.php?callapi=login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        if (SharedPrefManager(applicationContext).isLoggedIn()) {
            finish()
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }

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
            username = edit_text_login_id.text.toString().toLowerCase()
            password = edit_text_login_password.text.toString()
            corporate = spinnerCorporate.selectedItem.toString()
            level = spinnerLevel.selectedItem.toString()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

//            if (corporate == "Telin"){
//                corporate = "111111"
//            }
//
//            if (level == "User"){
//                level = "users"
//            }
//
//            if (validateInputs()){
//            login()
//            }


        }
    }

    private fun login() {
        class LoginService : AsyncTask<Void, Void, String>() {

            override fun onPreExecute() {
                super.onPreExecute()
            }

            override fun onPostExecute(s: String) {
                super.onPostExecute(s)

                try {
                    //converting response to json object
                    val obj = JSONObject(s)

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()

                        //getting the user from the response
                        val userJson = obj.getJSONObject("user")
                        val date = Date()


                        //creating a new user object
                        val user = User(
                            userJson.getInt("id"),
                            userJson.getString("username"),
                            userJson.getString("nik"),
                            userJson.getString("userlevel"),
                            userJson.getString("c_kode_unit"),
                            userJson.getString("email"),
                            date
                        )

                        //storing the user in shared preferences
                        SharedPrefManager(applicationContext).getInstance(applicationContext).userLogin(user)

                        //starting the main activity
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()

                    } else {
                        Toast.makeText(applicationContext, obj.getString("message"), Toast.LENGTH_SHORT).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }

            override fun doInBackground(vararg voids: Void): String {
                //creating request handler object
                val requestHandler = RequestHandler()

                //creating request parameters
                val params = hashMapOf<String, String>()
                params["username"] = username
                params["password"] = password
                params["corporate"] = corporate
                params["level"] = level

                //returing the response
                return requestHandler.sendPostRequest(loginUrl, params)
            }
        }

        val ul = LoginService()
        ul.execute()
    }

    /**
     * Validates inputs and shows error if any
     * @return
     */
    private fun validateInputs(): Boolean {
        if ("" == username) {
            edit_text_login_id.error = resources.getString(R.string.login_username_empty)
            edit_text_login_id.requestFocus()
            return false
        }
        if ("" == password) {
            edit_text_login_password.error = resources.getString(R.string.login_password_empty)
            edit_text_login_password.requestFocus()
            return false
        }
        return true
    }

}
