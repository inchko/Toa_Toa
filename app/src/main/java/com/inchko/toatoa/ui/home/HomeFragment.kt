package com.inchko.toatoa.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.inchko.toatoa.Data.Stores
import com.inchko.toatoa.R
import com.inchko.toatoa.ui.home.Stores.StoreAdapter
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_home.*

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

        testStores.add(
            Stores(
                "Panaderia Pepi",
                "Alimentacion",
                "Barcelona",
                "Una panaderia amigable en pleno centro"
            )
        )
        testStores.add(
            Stores(
                "Locomania",
                "Moda",
                "Barcelona",
                "Disfruta de los mejores ropajes de la ciudad!"
            )
        )
        testStores.add(Stores("Mando", "Tecnologia", "Sabadell", "Vendemos mandos, de lo que sea"))
        testStores.add(
            Stores(
                "Animal Limpio",
                "Animales",
                "Montcada",
                "Lo mejor para tu mejor amigo!"
            )
        )
        testStores.add(
            Stores(
                "Panaderia Pepi",
                "Alimentacion",
                "Barcelona",
                "Una panaderia amigable en pleno centro"
            )
        )
        testStores.add(
            Stores(
                "Locomania",
                "Moda",
                "Barcelona",
                "Disfruta de los mejores ropajes de la ciudad!"
            )
        )
        testStores.add(Stores("Mando", "Tecnologia", "Sabadell", "Vendemos mandos, de lo que sea"))
        testStores.add(
            Stores(
                "Animal Limpio",
                "Animales",
                "Montcada",
                "Lo mejor para tu mejor amigo!"
            )
        )
        testStores.add(
            Stores(
                "Panaderia Pepi",
                "Alimentacion",
                "Barcelona",
                "Una panaderia amigable en pleno centro"
            )
        )
        testStores.add(
            Stores(
                "Locomania",
                "Moda",
                "Barcelona",
                "Disfruta de los mejores ropajes de la ciudad!"
            )
        )
        testStores.add(Stores("Mando", "Tecnologia", "Sabadell", "Vendemos mandos, de lo que sea"))
        testStores.add(
            Stores(
                "Animal Limpio",
                "Animales",
                "Montcada",
                "Lo mejor para tu mejor amigo!"
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

                view.findNavController().navigate(R.id.action_nav_home_to_store_info)
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