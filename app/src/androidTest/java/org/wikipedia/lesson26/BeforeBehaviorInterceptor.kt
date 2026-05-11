package org.wikipedia.lesson26

import android.util.Log
import androidx.test.espresso.ViewInteraction
import com.kaspersky.kaspresso.interceptors.behavior.ViewBehaviorInterceptor

class BeforeBehaviorInterceptor : ViewBehaviorInterceptor {
    override fun <T> intercept(
        interaction: ViewInteraction,
        action: () -> T
    ): T {
        Log.i("KASPRESSO","BEFORE ACTION")
        val result =  action()
        Log.i("KASPRESSO","AFTER ACTION")
        return result
    }
}