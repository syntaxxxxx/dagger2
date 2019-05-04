
package com.syntax.android.learn.ui.search

interface EntryPresenter {
  fun setView(entryView: EntryView)

  fun getEntry(query: String)
}