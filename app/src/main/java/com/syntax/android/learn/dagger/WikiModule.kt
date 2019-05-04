package com.syntax.android.learn.dagger

import com.syntax.android.learn.network.Homepage
import com.syntax.android.learn.network.Wiki
import com.syntax.android.learn.network.WikiApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WikiModule {

    @Provides
    @Singleton
    fun provideHomePage(api: WikiApi) = Homepage(api)

    @Provides
    @Singleton
    fun provideWiki(api: WikiApi) = Wiki(api)
}