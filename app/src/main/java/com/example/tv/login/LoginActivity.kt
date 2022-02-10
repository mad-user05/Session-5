package com.example.tv.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tv.*
import com.example.tv.login.mdel.ModelInto
import com.example.tv.login.mdel.ModelTo
import com.example.tv.main.MainActivity
import com.example.tv.main.rtr.Inter
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun voiti() {
        val service = Inter.api
        val call = service.getLog(ModelInto(edit_email.toString(), edit_pas.toString()))
        call.enqueue(object : Callback<ModelTo> {
            override fun onResponse(call: Call<ModelTo>, response: Response<ModelTo>) {
                Log.d("BLOOP", response.body().toString())

            }

            override fun onFailure(call: Call<ModelTo>, t: Throwable) {
                Log.d("BLOOP", "OPOPO")
            }

        })
    }

    fun vvoitii(view: View) {
        if (edit_email.toString().isEmpty() || edit_pas.toString().isEmpty()) {
            Toast.makeText(
                this,
                "Ваши данные введены неверно, либо не введены!",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            voiti()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
