package org.wikipedia.lesson26

import android.util.Log
import android.view.View
import androidx.test.espresso.ViewAction
import com.kaspersky.kaspresso.interceptors.watcher.view.ViewActionWatcherInterceptor

class WatcherInterceptAction : ViewActionWatcherInterceptor  {
    override fun intercept(viewAction: ViewAction, view: View) {
        Log.i("KASPRESSO", "Description: ${viewAction.description}")
    }
}

