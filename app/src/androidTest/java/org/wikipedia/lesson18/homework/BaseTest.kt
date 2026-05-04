package org.wikipedia.lesson18.homework

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.ComposeConfig
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity

open class BaseTest : TestCase(
    Kaspresso.Builder
        .withForcedAllureSupport()
        .apply { ComposeConfig.Builder.default(this) {} }

) {

    @get:Rule
    val testRule = createAndroidComposeRule<MainActivity>()
}