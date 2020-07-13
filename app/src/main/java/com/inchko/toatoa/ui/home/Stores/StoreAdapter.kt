package com.inchko.toatoa.ui.home.Stores

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.inchko.toatoa.Data.Stores
import com.inchko.toatoa.R
import java.util.*
import kotlin.collections.ArrayList


class StoreAdapter(
    private val stores: ArrayList<Stores>,
    private val listener: (Stores) -> Unit
) : RecyclerView.Adapter<StoreHolder>(), Filterable {

    private var storesFilterList: ArrayList<Stores> = stores

    override fun getItemCount(): Int {
        return storesFilterList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = parent.inflate(R.layout.storerv_item, false)
        return StoreHolder(inflater, parent, inflatedView)
    }

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        val store = storesFilterList[position]
        holder.bind(store)
        holder.itemView.setOnClickListener { listener(store) }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    storesFilterList = stores
                } else {
                    val resultList = ArrayList<Stores>()
                    for (row in stores) {
                        if (row.title.toLowerCase(Locale.ROOT)
                                .contains(charSearch.toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    storesFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = storesFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                storesFilterList = results?.values as ArrayList<Stores>
                notifyDataSetChanged()
            }

        }
    }
}