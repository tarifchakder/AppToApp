package com.tarif.serverapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class AppToAppBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        if (action != null) {
            if (action == "com.tarif.serverapp.APP_TO_APP") {
                val amount = intent.getStringExtra("amount")
                val trans = intent.getStringExtra("trans")
                val i = Intent(context, MainActivity::class.java)
                i.putExtra("amount", amount)
                i.putExtra("trans", trans)
                context?.startActivity(i)
            }
        }
    }
}