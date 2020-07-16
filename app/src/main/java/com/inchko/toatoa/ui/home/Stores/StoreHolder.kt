package com.inchko.toatoa.ui.home.Stores

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.inchko.toatoa.Data.Stores
import com.inchko.toatoa.R

class StoreHolder(inflater: LayoutInflater, parent: ViewGroup, v: View) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.storerv_item, parent, false
    )
), View.OnClickListener {

    private var titleView: TextView? = null
    private var cityView: TextView? = null
    private var descView: TextView? = null
    private var catView: TextView? = null

    init {
        titleView = itemView.findViewById(R.id.Title)
        cityView = itemView.findViewById(R.id.City)
        descView = itemView.findViewById(R.id.Description)
        catView = itemView.findViewById(R.id.Category)
        v.setOnClickListener(this)
    }

    fun bind(store: Stores) {
        titleView?.text = store.title
        cityView?.text = store.City
        descView?.text = store.Description
        catView?.text = store.Categoria

    }


    override fun onClick(p0: View?) {
        Log.d("RecyclerView", "CLICK!")
      //  p0?.findNavController()?.navigate(R.id.action_nav_home_to_store_info)
    }

}
