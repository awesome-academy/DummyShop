package com.sun.dummyshop

import android.app.Application
import com.sun.dummyshop.di.databaseModule
import com.sun.dummyshop.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DummyShopApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DummyShopApplication)
            modules(
                databaseModule,
                repositoryModule
            )
        }
    }
}
