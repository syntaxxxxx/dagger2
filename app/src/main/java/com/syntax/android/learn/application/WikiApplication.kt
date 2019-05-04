package com.syntax.android.learn.application

import android.app.Application
import com.syntax.android.learn.dagger.AppComponent
import com.syntax.android.learn.dagger.AppModule
import com.syntax.android.learn.dagger.DaggerAppComponent

class WikiApplication : Application() {

    lateinit var wikiComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        wikiComponent = initDagger(this)
    }

    private fun initDagger(app: WikiApplication): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}