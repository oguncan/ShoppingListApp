package com.oguncan.shoppinglistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oguncan.shoppinglistapp.R
import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem
import com.oguncan.shoppinglistapp.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var itemList : List<ShoppingItem>,
    private val viewModel : ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {



    class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.itemView.txtViewName.text = itemList.get(position).name
        holder.itemView.txtViewAmount.text = itemList.get(position).amount.toString()

        holder.itemView.imgViewDelete.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                viewModel.delete(itemList.get(position))
            }
        })

        holder.itemView.imgViewDecrease.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if(itemList.get(position).amount > 0) {
                    itemList.get(position).amount--
                    viewModel.insert(itemList.get(position))
                }
            }
        })

        holder.itemView.imgViewIncrease.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                    itemList.get(position).amount++
                    viewModel.insert(itemList.get(position))
            }
        })
    }
}