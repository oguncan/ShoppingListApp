package com.oguncan.shoppinglistapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.oguncan.shoppinglistapp.R
import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*
import kotlinx.android.synthetic.main.shopping_item.*

class AddShoppingItemDialog(context : Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        txtViewAdd.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val name = edtTextName.text.toString()
                val amount = edtTextAmount.text.toString()

                if(name.isEmpty() || amount.isEmpty()){
                    Toast.makeText(context, "Lütfen Boşlukları Doldurunuz!", Toast.LENGTH_SHORT).show()
                    return
                }

                val item = ShoppingItem(name, Integer.parseInt(amount))
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }
        })

        txtViewCancel.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                cancel()
            }
        })
    }
}