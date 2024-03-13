package com.kevinmuchene.electronicsgadget

import android.content.Intent
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

        recyclerView = findViewById(R.id.recycler_viewId)
        viewCartButton = findViewById(R.id.view_cart_button)

        val products = arrayListOf(
            Product(R.drawable.iphone, R.drawable.iphone,"iPhone", "Iphone Titainium", 2500.0),
            Product(R.drawable.hp, R.drawable.hp,"HP", "Fast Laptop",3000.0),
            Product(R.drawable.ps, R.drawable.ps, "PS", "Play Station", 400.0),
            Product(R.drawable.dell, R.drawable.dell, "DELL", "DELL Laptop", 37000.0),
            Product(R.drawable.sumsang, R.drawable.sumsang, "SAMSUNG", "Samsung Laptop", 3500.0)

        )

        val adapter = ProductAdapter(products, { product ->
            cartItems.add(product)
            Toast.makeText(this, "${product.productName} added to cart", Toast.LENGTH_SHORT).show()
        }, { product ->

            val intent = Intent(this, ProductDetails::class.java).apply {
                putExtra("PRODUCT_NAME", product.productName)
                putExtra("PRODUCT_DESC", product.productDescription)
                putExtra("PRODUCT_COST", product.cost)
                putExtra("PRODUCT_IMAGE", product.productImage)
            }
            startActivity(intent)
        })



        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        viewCartButton.setOnClickListener {
            val cartList = cartItems.joinToString("\n") { it.productName}
            Toast.makeText(this, cartList, Toast.LENGTH_SHORT).show()
        }
    }
}
