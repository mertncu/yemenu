package com.eosdev.yemenu.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eosdev.yemenu.R
import com.eosdev.yemenu.data.api.ApiClient
import com.eosdev.yemenu.data.api.ApiService
import com.eosdev.yemenu.data.model.User
import com.eosdev.yemenu.data.model.UserForLoginDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var register: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.login_email)
        password = findViewById(R.id.login_password)
        login = findViewById(R.id.btn_login)
        register = findViewById(R.id.register)

        login.setOnClickListener {

            val email = email.text.toString()
            val password = password.text.toString()
            val userForLoginDto = UserForLoginDto(email, password)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val apiService = ApiClient.retrofit.create(ApiService::class.java)
                apiService.login(userForLoginDto).enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@LoginActivity, "Giriş Yapıldı!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        } else {
                            Toast.makeText(this@LoginActivity, "Giriş Yaparken Hata oluştu", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Network error", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this, "Lütfen Bütün Alanları Doldurunuz!", Toast.LENGTH_SHORT).show()
            }
        }

        register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
