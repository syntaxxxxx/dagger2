package com.syntax.android.learn.dagger

import android.app.Application
import android.content.Context
import com.syntax.android.learn.ui.homepage.HomepagePresenter
import com.syntax.android.learn.ui.homepage.HomepagePresenterImpl
import com.syntax.android.learn.ui.search.EntryPresenter
import com.syntax.android.learn.ui.search.EntryPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule() {
    @Provides
    @Singleton
    fun provideHomePagePresenter() : HomepagePresenter = HomepagePresenterImpl()

    @Provides
    @Singleton
    fun provideSearchPresenter() : EntryPresenter = EntryPresenterImpl()
}