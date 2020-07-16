package com.inchko.toatoa.ui.storeView.PhotoSlider

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.inchko.toatoa.R
import java.net.URL

class photoSliderBigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_slider_big)
        val view = findViewById<ImageView>(R.id.photosSliderBig)
        Glide.with(view)
            .load(URL(intent.getStringExtra("url")))
            .fitCenter()
            .into(view)
        val button = findViewById<Button>(R.id.PSBback).setOnClickListener{
            finish()
        }

        intent.getStringExtra("url")
    }
}