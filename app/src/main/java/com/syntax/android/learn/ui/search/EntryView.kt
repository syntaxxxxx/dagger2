

package com.syntax.android.learn.ui.search

import com.syntax.android.learn.model.Entry

interface EntryView {
  fun displayLoading()

  fun dismissLoading()

  fun displayEntries(results: List<Entry>)

  fun displayError(error: String?)
}