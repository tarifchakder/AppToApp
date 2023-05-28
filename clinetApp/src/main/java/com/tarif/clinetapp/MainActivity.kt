package com.tarif.clinetapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tarif.clinetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            btnOpen.setOnClickListener {
                Intent().also { intent ->
                    intent.action = "com.tarif.serverapp.APP_TO_APP"
                    intent.putExtra("amount","100")
                    intent.putExtra("trans","SALE")
                    intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                    sendBroadcast(intent)
                }
            }
        }
    }

}