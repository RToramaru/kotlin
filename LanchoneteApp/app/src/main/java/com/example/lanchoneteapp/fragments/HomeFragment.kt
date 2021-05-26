package com.example.lanchoneteapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationworkapi.api.MyRetrofit
import com.example.applicationworkapi.model.Product
import com.example.lanchoneteapp.FragmentsActivity
import com.example.lanchoneteapp.MainActivity
import com.example.lanchoneteapp.ProductAdapter
import com.example.lanchoneteapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    lateinit var recyclerProducts: RecyclerView


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerProducts = view.findViewById(R.id.product_list_recycler) as RecyclerView
        recyclerProducts.layoutManager = LinearLayoutManager(context)
        getData()
    }


    private fun getData(){
        val call: Call<List<Product>> = MyRetrofit.instance?.productApi()?.getProductApi() as Call<List<Product>>

        call.enqueue(object : Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable) =
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val adapter = ProductAdapter(this@HomeFragment, response.body()?.toList() as List<Product>)
                recyclerProducts.adapter = adapter
            }

        })
    }
}