package com.inchko.toatoa.ui.storeView

import android.graphics.Color
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.inchko.toatoa.R
import com.inchko.toatoa.ui.storeView.PhotoSlider.photoSliderAdapter
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import java.net.URL


class store_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_info)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title =
            intent.getStringExtra("title")
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(
                view,
                "Here will be the option to scan QR for adding points",
                Snackbar.LENGTH_LONG
            )
                .setAction("Action", null).show()
        }
        findViewById<TextView>(R.id.storeDescription).text = intent.getStringExtra("description")
        findViewById<TextView>(R.id.storeCategory).text = intent.getStringExtra("category")
        findViewById<TextView>(R.id.storeCity).text = intent.getStringExtra("city")
        findViewById<RatingBar>(R.id.storeRating).rating = intent.getFloatExtra("rating", 0f)

        val sliderView = findViewById<SliderView>(R.id.storePhotoSlider)

        val adapter = photoSliderAdapter(this)
        adapter.renewItems(intent.getStringArrayListExtra("Photos") as MutableList<String>)
        sliderView.setSliderAdapter(adapter)

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        sliderView.indicatorSelectedColor = Color.WHITE
        sliderView.indicatorUnselectedColor = Color.GRAY
        sliderView.scrollTimeInSec = 4 //set scroll delay in seconds :
        sliderView.startAutoCycle()

    }
}