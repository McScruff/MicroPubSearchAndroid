package com.tts.mcscruff.micropubsearchandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.Toast
import com.beust.klaxon.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import android.widget.RadioButton
import android.widget.RadioGroup


//import com.tts.mcscruff.micropubsearchandroid.klaxon.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = RecyclerView as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        //crating an arraylist to store users using the data class user
        val pubs = ArrayList<PubDetails>()



        //time to read from the json
        //open micropub json
        val obj = parse("/assets/MicroPubs.json") as JsonArray<JsonObject>

        //creating our adapter
        val adapter = CustomAdapter(pubs)

        //now adding the adapter to recyclerview
        // recyclerView.adapter = adapter

        btn_Search.setOnClickListener {
            // Handler code here.
            // Toast.makeText(this, txt_SearchBox2.editableText,
            //        Toast.LENGTH_LONG).show()
            //ADD PUBS HERE
            val SearchText = txt_SearchBox2.editableText.toString()
            GetPubDetails(SearchText)

            /////
            //recyclerView.adapter = adapter
        }

        
    }

    fun parse(name: String): Any? {

        val cls = Parser::class.java
        return cls.getResourceAsStream(name)?.let { inputStream ->
            return Parser().parse(inputStream)
        }
    }


    fun GetPubDetails(Name: String) {

        val pubs = ArrayList<PubDetails>()
        val recyclerView = RecyclerView as RecyclerView
        val obj = parse("/assets/MicroPubs.json") as JsonArray<JsonObject>

        //search the text box to the json file
        //SEARCH BY TOWN
        if (rdo_Town.isChecked) {
            val InTown = obj.filter {
                it.string("Town").equals(Name, true)
            }.map {
                val InPubName = it.string("PubName")
                val InPubAddress = it.string("Address")
                //print output to console
                //println("$InPubName : $InPubAddress")

                pubs.add(PubDetails("$InPubName", "$InPubAddress"))
            }
        }

        //SEARCH BY COUNTY
        if (rdo_County.isChecked) {
            val InCounty = obj.filter {
                it.string("County").equals(Name, true)
            }.map {
                val InPubName = it.string("PubName")
                val InPubAddress = it.string("Address")
                //print output to console
                //println("$InPubName : $InPubAddress")

                pubs.add(PubDetails("$InPubName", "$InPubAddress"))
            }
        }

            val adapter = CustomAdapter(pubs)

            //now adding the adapter to recyclerview
            recyclerView.adapter = adapter
        }

    }
