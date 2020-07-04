package com.oguncan.shoppinglistapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem

@Dao
interface ShoppingDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>
}