package com.inchko.toatoa.ui.home.Stores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inchko.toatoa.Data.Stores
import com.inchko.toatoa.R
import kotlinx.android.synthetic.main.fragment_home.*


class StoreAdapter(
    private val stores: ArrayList<Stores>,
    private val listener: (Stores) -> Unit
) : RecyclerView.Adapter<StoreHolder>() {

    override fun getItemCount(): Int {
        return stores.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = parent.inflate(R.layout.storerv_item, false)
        return StoreHolder(inflater, parent, inflatedView)
    }

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        val store = stores[position]
        holder.bind(store)
        holder.itemView.setOnClickListener { listener(store) }
    }
}