package com.kevinmuchene.electronicsgadget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>,
    private val onAddClick: (Product) -> Unit,
    private val onItemClick: (Product) -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.product_image)
        val productLogo: ImageView = view.findViewById(R.id.productLogoId)
        val productName: TextView = view.findViewById(R.id.product_nameId)
        val productDescription: TextView = view.findViewById(R.id.product_descriptionId)
        val productCost: TextView = view.findViewById(R.id.product_CostId)
        val addButton: Button = view.findViewById(R.id.add_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productImage.setImageResource(product.productImage)
        holder.productLogo.setImageResource(product.productLogo)
        holder.productName.text = product.productName
        holder.productDescription.text = product.productDescription
        holder.productCost.text = "$${product.cost}"
        holder.addButton.setOnClickListener { onAddClick(product) }
        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }
    override fun getItemCount() = productList.size
}
