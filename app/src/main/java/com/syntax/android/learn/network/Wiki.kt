
package com.syntax.android.learn.network

class Wiki(private val api: WikiApi) {
  fun search(query: String) = api.search(query)
}
