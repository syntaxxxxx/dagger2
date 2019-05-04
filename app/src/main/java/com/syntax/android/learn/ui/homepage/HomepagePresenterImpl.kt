package com.syntax.android.learn.ui.homepage

import com.syntax.android.learn.network.Homepage
import com.syntax.android.learn.model.HomepageResult
import com.syntax.android.learn.network.WikiApi
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class HomepagePresenterImpl @Inject constructor(private val homepage: Homepage) : HomepagePresenter {

    private lateinit var homepageView: HomepageView

    override fun setView(homepageView: HomepageView) {
        this.homepageView = homepageView
    }

    override fun loadHomepage() {
        homepageView.displayLoading()
        homepage.get().enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                homepageView.dismissLoading()
                if (response?.isSuccessful == true) {
                    response.let {
                        HomepageResult(it).homepage?.let {
                            homepageView.displayHomepage(it)
                        } ?: run {
                            homepageView.displayError(response.message())
                        }
                    }

                } else {
                    homepageView.displayError(response?.message())
                }
            }

            override fun onFailure(call: Call?, t: IOException?) {
                homepageView.displayError(t?.message)
                t?.printStackTrace()
            }
        })
    }
}