package com.tarif.serverapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tarif.serverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val amount = intent?.getStringExtra("amount") ?: ""
        val trans = intent?.getStringExtra("trans") ?: ""

        with(binding){
            setContentView(root)
            extraTxt.text = "Amount : $amount \nTransaction Type : $trans"
        }

    }
}