package com.syntax.android.learn.dagger

import com.syntax.android.learn.network.Homepage
import com.syntax.android.learn.network.WikiApi
import com.syntax.android.learn.utils.Const
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "BASE_URL"
    }

    @Provides
    @Named(BASE_URL)
    fun provideBaseUrlString() = "${Const.PROTOCOL}://${Const.LANGUAGE}.${Const.BASE_URL}"

    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideRequestBuilder(@Named(BASE_URL) base_url : String) =
            HttpUrl.parse(base_url)?.newBuilder()

    @Provides
    @Singleton
    fun provideWikiApi(client: OkHttpClient, requestBuilder: HttpUrl.Builder?) =
            WikiApi(client, requestBuilder)
}