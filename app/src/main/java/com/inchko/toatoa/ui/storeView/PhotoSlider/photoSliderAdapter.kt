package com.inchko.toatoa.ui.storeView.PhotoSlider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.inchko.toatoa.R
import com.smarteist.autoimageslider.SliderViewAdapter
import java.net.URL


class photoSliderAdapter(context: Context) :
    SliderViewAdapter<photoSliderAdapter.SliderAdapterVH>() {
    private val context: Context = context
    private var mSliderItems: MutableList<String> = ArrayList()
    fun renewItems(sliderItems: MutableList<String>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mSliderItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: String) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_slider_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(
        viewHolder: SliderAdapterVH,
        position: Int
    ) {
        val sliderItem: String = mSliderItems[position]
        Glide.with(viewHolder.itemView)
            .load(URL(sliderItem))
            .fitCenter()
            .into(viewHolder.imageViewBackground)
        viewHolder.itemView.setOnClickListener {
            Toast.makeText(context, "This is item in position $position", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mSliderItems.size
    }

    inner class SliderAdapterVH(itemView: View) :
        ViewHolder(itemView) {
        var itemViewVH: View = itemView
        var imageViewBackground: ImageView = itemView.findViewById(R.id.photoSliderView)


        init {
            /* imageGifContainer = itemView.findViewById(R.id.iv_gif_container)
             textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider)*/
        }
    }

}