package com.syntax.android.learn.dagger

import android.app.Application
import android.content.Context
import com.syntax.android.learn.network.Homepage
import com.syntax.android.learn.network.Wiki
import com.syntax.android.learn.ui.homepage.HomepagePresenter
import com.syntax.android.learn.ui.homepage.HomepagePresenterImpl
import com.syntax.android.learn.ui.search.EntryPresenter
import com.syntax.android.learn.ui.search.EntryPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideHomePagePresenter(homepage: Homepage): HomepagePresenter = HomepagePresenterImpl(homepage)

    @Provides
    @Singleton
    fun provideSearchPresenter(wiki: Wiki): EntryPresenter = EntryPresenterImpl(wiki)
}