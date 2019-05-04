

package com.syntax.android.learn.ui.search

import com.syntax.android.learn.network.Wiki
import com.syntax.android.learn.model.SearchResult
import com.syntax.android.learn.network.WikiApi
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class EntryPresenterImpl @Inject constructor(private val wiki: Wiki): EntryPresenter {

  private lateinit var entryView: EntryView

  override fun setView(entryView: EntryView) {
    this.entryView = entryView
  }

  override fun getEntry(query: String) {
    entryView.displayLoading()
    wiki.search(query).enqueue(object : Callback {
      override fun onResponse(call: Call?, response: Response?) {
        entryView.dismissLoading()
        //Everything is ok, show the result if not null
        if (response?.isSuccessful == true) {
          SearchResult(response).list?.let {
            entryView.displayEntries(it)
          }
        } else {
          entryView.displayError(response?.message())
        }
      }

      override fun onFailure(call: Call?, t: IOException?) {
        entryView.displayError(t?.message)
        t?.printStackTrace()
      }
    })

  }
}