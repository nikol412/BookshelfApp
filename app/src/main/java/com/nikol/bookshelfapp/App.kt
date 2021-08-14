package com.nikol.bookshelfapp

import android.app.Application
import com.nikol.bookshelfapp.data.modules.networkModule
import com.nikol.bookshelfapp.data.modules.repositoryModule
import com.nikol.bookshelfapp.data.modules.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelsModule
                )
            )
        }
    }
}