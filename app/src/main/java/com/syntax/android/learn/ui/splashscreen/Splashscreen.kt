

package com.syntax.android.learn.ui.splashscreen

import android.app.Activity
import android.os.Bundle
import com.syntax.android.learn.ui.homepage.HomepageActivity
import com.syntax.android.learn.utils.start

class Splashscreen : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    HomepageActivity::class.start(this, true)
  }
}