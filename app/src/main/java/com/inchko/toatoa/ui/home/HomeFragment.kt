package com.inchko.toatoa.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.inchko.toatoa.Data.Stores
import com.inchko.toatoa.R
import com.inchko.toatoa.ui.storeView.store_info
import com.inchko.toatoa.ui.home.Stores.StoreAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import java.net.URL

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var testStores: ArrayList<Stores>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        testStores = ArrayList()
        val testPhoto = ArrayList<String>()
        val testUrl = "https://i.imgur.com/YxkRbSU.jpeg"
        val testUrl2 = "https://i.imgur.com/zwcrBYU.jpeg"
        testPhoto.add(testUrl)
        testPhoto.add(testUrl2)

        testStores.add(
            Stores(
                "Panaderia Pepi",
                "Alimentacion",
                "Barcelona",
                "Una panaderia amigable en pleno centro",
                4.7f,
                testPhoto
            )
        )
        testStores.add(
            Stores(
                "Locomania",
                "Moda",
                "Barcelona",
                "Disfruta de los mejores ropajes de la ciudad!",
                3.8f,
                testPhoto
            )
        )
        testStores.add(
            Stores(
                "Mando",
                "Tecnologia",
                "Sabadell",
                "Vendemos mandos, de lo que sea",
                1.3f,
                testPhoto
            )
        )
        testStores.add(
            Stores(
                "Animal Limpio",
                "Animales",
                "Montcada",
                "Lo mejor para tu mejor amigo!",
                2.3f,
                testPhoto
            )
        )

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // RecyclerView node initialized here
        storesRV.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = StoreAdapter(testStores) {
                val intent = Intent(context, store_info::class.java).apply {
                    putExtra("title", it.title)
                    putExtra("description", it.Description)
                    putExtra("city", it.City)
                    putExtra("category", it.Categoria)
                    putExtra("rating", it.Rating)
                    putExtra("Photos", it.photos)
                }
                startActivity(intent)

                // view.findNavController().navigate(R.id.action_nav_home_to_store_info)
            };

            storeSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    (adapter as StoreAdapter).filter.filter(newText)
                    return false
                }
            })
        }
    }
}