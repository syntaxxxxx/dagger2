package com.syntax.android.learn.dagger

import com.syntax.android.learn.ui.homepage.HomepageActivity
import com.syntax.android.learn.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(target: HomepageActivity)
    fun inject(target: SearchActivity)
}