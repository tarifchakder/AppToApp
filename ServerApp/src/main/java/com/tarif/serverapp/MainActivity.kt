package com.tarif.serverapp

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tarif.serverapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var receiver: AppToAppBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val amount = intent?.getStringExtra("amount") ?: ""
        val trans = intent?.getStringExtra("trans") ?: ""

        with(binding){
            setContentView(root)
            extraTxt.text = amount + trans
        }

        receiver = AppToAppBroadcast()
        registerReceiver(receiver, IntentFilter().apply {
            addAction("com.tarif.serverapp.APP_TO_APP")
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}