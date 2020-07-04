package com.oguncan.shoppinglistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oguncan.shoppinglistapp.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase : RoomDatabase(){

    abstract fun getShoppingDAO() : ShoppingDAO

    companion object{
        @Volatile
        private var instance : ShoppingDatabase? = null

        private var lock  = Any()
        operator fun invoke(context : Context) = instance
            ?: synchronized(lock) {
            instance
                ?: createDatabase(
                    context
                ).also {
                instance = it
            }
        }

        private fun createDatabase(context : Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingDB")
            .build()
    }
}