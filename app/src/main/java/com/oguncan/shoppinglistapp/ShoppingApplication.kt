package com.oguncan.shoppinglistapp

import android.app.Application
import com.oguncan.shoppinglistapp.data.db.ShoppingDatabase
import com.oguncan.shoppinglistapp.data.repositories.ShoppingRepository
import com.oguncan.shoppinglistapp.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind


class ShoppingApplication : Application(), DIAware {

    override val di: DI = DI.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind() from singleton { ShoppingDatabase(instance())}
        bind() from singleton { ShoppingRepository(instance())}
        bind() from provider {
            ShoppingViewModelFactory(instance())
        }


    }
}