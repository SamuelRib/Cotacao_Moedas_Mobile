package com.sam.cotacao_moedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sam.cotacao_moedas.api.ApiCotacao
import com.sam.cotacao_moedas.databinding.ActivityMainBinding
import com.sam.cotacao_moedas.model.ParMoeda
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //Retrofit configuração
        val retrofit = Retrofit.Builder()
            .baseUrl("https://economia.awesomeapi.com.br/json/last/")
            .addConverterFactory(GsonConverterFactory.create())

            .build()
            .create(ApiCotacao::class.java)

        fun atualizarMoedas(){
            val finalURL = "USD-BRL,EUR-BRL,BTC-BRL,ETH-BRL"
            retrofit.setMoeda(finalURL).enqueue(object : Callback<ParMoeda>{
                override fun onResponse(call: Call<ParMoeda>, response: Response<ParMoeda>) {
                    if (response.code() == 200){
                        val dolar1 = response.body()?.USDBRL?.bid.toString()
                        val euro = response.body()?.EURBRL?.bid.toString()
                        val btc = response.body()?.BTCBRL?.bid.toString()
                        val eth = response.body()?.ETHBRL?.bid.toString()
                        setMoedas(dolar1, euro, btc, eth)
                    }
                    else{
                        Toast.makeText(applicationContext,"Deu erro!",Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ParMoeda>, t: Throwable) {
                    Toast.makeText(applicationContext,"Erro inesperado",Toast.LENGTH_SHORT).show()
                }
            })
        }

        atualizarMoedas()

        binding.btAtualizar.setOnClickListener {
            atualizarMoedas()
        }
    }

    private fun setMoedas (dolar1: String, euro: String, btc: String, eth: String){
       binding.txtDolar.setText(dolar1)
       binding.txtEuro.setText(euro)
       binding.txtBtc.setText(btc)
       binding.txtEth.setText(eth)
    }

}
