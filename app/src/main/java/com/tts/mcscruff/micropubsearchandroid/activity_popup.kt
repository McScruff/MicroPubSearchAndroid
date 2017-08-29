package com.tts.mcscruff.micropubsearchandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_popup.*
import kotlinx.android.synthetic.main.list_layout.*
import android.support.v4.app.NotificationCompat.getExtras
import android.content.Intent



class activity_popup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        //val PubName = pubDetails.PubName
        //val PubAddress = pubDetails.PubAddress
        val intent = intent
        val bundle = intent.extras
        val PubName = bundle.get("PubName") as String
        val PubAddress = bundle.get("PubAddress") as String
        txt_PubName.text = PubName
        txt_PubAddress.text = PubAddress
    }




}
