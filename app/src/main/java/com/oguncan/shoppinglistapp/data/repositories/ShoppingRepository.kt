package com.oguncan.shoppinglistapp.data.repositories

import com.oguncan.shoppinglistapp.data.db.ShoppingDatabase
import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db : ShoppingDatabase
) {
    suspend fun insert(item : ShoppingItem) = db.getShoppingDAO().insert(item)

    suspend fun delete(item : ShoppingItem) = db.getShoppingDAO().delete(item)

    fun getAllShoppingItems() = db.getShoppingDAO().getAllShoppingItems()
}