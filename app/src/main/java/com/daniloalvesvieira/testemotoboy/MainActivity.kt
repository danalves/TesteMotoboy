package com.daniloalvesvieira.testemotoboy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daniloalvesvieira.testemotoboy.api.MotoboyAPI
import com.daniloalvesvieira.testemotoboy.model.RetornoAutent
import com.daniloalvesvieira.testemotoboy.model.RetornoOrcamento
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val url = "https://www.motoboy.com/apiV1/"
    val username = "teste-api@motoboy.com"
    val key = "eJNQ6DPGKFr521zwshtNxntVembCJ2qu"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(MotoboyAPI::class.java)
        api.autenticar(username, key)
                .enqueue(object : Callback<RetornoAutent> {
                    override fun onResponse(call: Call<RetornoAutent>?, response: Response<RetornoAutent>?) {
                        val teste1 = response?.body()?.success
                        val teste2 = response?.body()?.msg
                    }

                    override fun onFailure(call: Call<RetornoAutent>?, t: Throwable?) {
                        Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show()
                    }
                })



        api.solicitarOrcamento("sp/sao-paulo", "06540235", "06543001")
                .enqueue(object : Callback<RetornoOrcamento> {
                    override fun onResponse(call: Call<RetornoOrcamento>?, response: Response<RetornoOrcamento>?) {
                        val teste1 = response?.body()?.success
                        val teste2 = response?.body()?.msg
                    }

                    override fun onFailure(call: Call<RetornoOrcamento>?, t: Throwable?) {
                        Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show()
                    }
                })


    }
}
