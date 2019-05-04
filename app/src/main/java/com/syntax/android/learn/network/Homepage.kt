
package com.syntax.android.learn.network

class Homepage(private val api: WikiApi) {
  fun get() = api.getHomepage()
}