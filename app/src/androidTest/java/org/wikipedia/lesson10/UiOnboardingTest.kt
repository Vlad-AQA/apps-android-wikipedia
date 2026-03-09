package org.wikipedia.lesson10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class UiOnboardingTest : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSkipButton() {
        run {
            OnboardingUiScreen.skip.isDisplayed()
            OnboardingScreen.skip.isDisplayed()
        }
    }


}