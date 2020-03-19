package xyz.phongtoanhuu.nhongxichkhopnoi.base

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import xyz.phongtoanhuu.nhongxichkhopnoi.di.appModule
import xyz.phongtoanhuu.nhongxichkhopnoi.di.fragmentModule
import xyz.phongtoanhuu.nhongxichkhopnoi.di.repositoryModule
import xyz.phongtoanhuu.nhongxichkhopnoi.di.viewModelModule

class BaseApplication : Application() {
    private val appComponent = listOf(appModule, viewModelModule, repositoryModule, fragmentModule)
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            androidFileProperties()
            modules(appComponent)
        }
    }
}