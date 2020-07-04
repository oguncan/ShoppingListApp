package com.oguncan.shoppinglistapp.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.oguncan.shoppinglistapp.R
import com.oguncan.shoppinglistapp.data.db.ShoppingDatabase
import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem
import com.oguncan.shoppinglistapp.data.repositories.ShoppingRepository
import com.oguncan.shoppinglistapp.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.DIAware
import org.kodein.di.android.di
import org.kodein.di.instance

class ShoppingActivity : AppCompatActivity(), DIAware{

    override val di by di()
    private val factory : ShoppingViewModelFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)



//        val database = ShoppingDatabase(this)
//        val repository = ShoppingRepository(database)
//        val viewModelFactory : ShoppingViewModelFactory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        recyclerViewShoppingItems.layoutManager = LinearLayoutManager(this)
        recyclerViewShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.itemList = it
            adapter.notifyDataSetChanged()
        })

        btnNewShoppingListItem.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                AddShoppingItemDialog(this@ShoppingActivity, object : AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.insert(item)
                    }
                }).show()
            }

        })
    }
}
