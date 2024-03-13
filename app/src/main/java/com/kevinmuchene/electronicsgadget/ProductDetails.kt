package com.kevinmuchene.electronicsgadget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productDesc = intent.getStringExtra("PRODUCT_DESC")
        val productCost = intent.getDoubleExtra("PRODUCT_COST", 0.0)
        val productImage = intent.getIntExtra("PRODUCT_IMAGE", 0)

        findViewById<TextView>(R.id.productDetailNameId).text = productName
        findViewById<TextView>(R.id.productDetailDescriptionId).text = productDesc
        findViewById<TextView>(R.id.productDetailCostId).text = "$$productCost"
        findViewById<ImageView>(R.id.productDetailLogoId).setImageResource(productImage)
    }
}
