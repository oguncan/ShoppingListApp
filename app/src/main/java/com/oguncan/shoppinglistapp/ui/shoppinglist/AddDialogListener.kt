package com.oguncan.shoppinglistapp.ui.shoppinglist

import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item : ShoppingItem)
}