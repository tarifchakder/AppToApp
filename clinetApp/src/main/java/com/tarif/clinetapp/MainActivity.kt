package com.tarif.clinetapp

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.KeyEventDispatcher.Component
import com.tarif.clinetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            btnOpen.setOnClickListener {
                Intent(Intent.ACTION_MAIN).also {
                    it.addCategory("com.tarif.serverapp.APP_TO_APP")
                    it.component = ComponentName("com.tarif.serverapp","com.tarif.serverapp.MainActivity")
                    it.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                    it.putExtra("amount","1000")
                    it.putExtra("trans","SALE")
                }.let {
                    startActivity(it)
                }
            }
        }
    }

}