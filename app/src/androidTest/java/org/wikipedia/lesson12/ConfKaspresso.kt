package org.wikipedia.lesson12

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.FlakySafetyParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

abstract class ConfKaspresso(
    kaspressoBuilder: Kaspresso.Builder =
        Kaspresso.Builder.simple {
            flakySafetyParams = FlakySafetyParams.custom(
                timeoutMs = 30000
            )

        }
) : TestCase(


) {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkCustom() {
        run {
            OnboardingScreen.skip.hasText("no")
        }
    }
}

class CustomTest() : ConfKaspresso(Kaspresso.Builder.simple {
    flakySafetyParams = FlakySafetyParams.custom(
        timeoutMs = 80000
    )

})