package org.wikipedia.lesson27.homework

import android.util.Log
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class DeprecatedSkipTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport()
) {

    @get:Rule
    val deprecatedSkipRule = DeprecatedSkipRule()

    @Test
    fun firstTest() {
        Log.i("KASPRESSO", "firstTest executed")
    }

    @Test
    fun secondTest() {
        Log.i("KASPRESSO", "secondTest executed")
    }

    @Test
    @Deprecated("Тест устарел, скипаем")
    fun deprecatedTest() {
        Log.i("KASPRESSO", "deprecatedTest executed — этого лога быть не должно")
    }

    @Test
    fun thirdTest() {
        Log.i("KASPRESSO", "thirdTest executed")
    }
}
