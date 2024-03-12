package com.kevinmuchene.electronicsgadget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewCartButton: Button
    private var cartItems = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        viewCartButton = findViewById(R.id.view_cart_button)

        val products = arrayListOf(
            Product("iPad", "iPad Pro", 2500.0),

        )

        val adapter = ProductAdapter(products) { product ->
            cartItems.add(product)
            Toast.makeText(this, "${product.productName} added to cart", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewCartButton.setOnClickListener {
            val cartList = cartItems.joinToString("\n") { it.productName + " - $" + it.cost }

        }
    }
}
