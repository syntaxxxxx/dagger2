
package com.syntax.android.learn.ui.homepage

import com.syntax.android.learn.network.Homepage
import com.syntax.android.learn.model.HomepageResult
import com.syntax.android.learn.network.WikiApi
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

class HomepagePresenterImpl( private var homepageView: HomepageView) : HomepagePresenter {

  private val client: OkHttpClient = OkHttpClient()
  private val api: WikiApi = WikiApi(client)
  private val homepage: Homepage = Homepage(api)

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