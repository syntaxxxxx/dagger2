
package com.syntax.android.learn.ui.homepage

import com.syntax.android.learn.model.WikiHomepage

interface HomepageView {
  fun displayLoading()

  fun dismissLoading()

  fun displayHomepage(result: WikiHomepage)

  fun displayError(error: String?)
}