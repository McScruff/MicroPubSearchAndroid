package com.tts.mcscruff.micropubsearchandroid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.list_layout.view.*

class CustomAdapter(val PubList: ArrayList<PubDetails>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)

        return ViewHolder(v)

    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(PubList[position])

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return PubList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(pubdetails: PubDetails) {

            val textViewPubName = itemView.textViewPubName as TextView
            val textViewAddress = itemView.textViewPubAddress as TextView
            textViewPubName.text = pubdetails.PubName
            textViewAddress.text = pubdetails.PubAddress

            // example of setting the click listener here
            itemView.setOnClickListener({
                println("${pubdetails.PubName} -- ${pubdetails.PubAddress}")
            })

//            itemView.setOnClickListener {
//                // example of using the static method on ItemPressed class
//                // this is static cause we're not creating an instance of ItemPressed
//                ItemPressed(pubdetails.PubName, pubdetails.PubAddress)
//            }
        }
    }
}