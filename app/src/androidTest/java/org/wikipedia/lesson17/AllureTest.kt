package org.wikipedia.lesson17


import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class AllureTest : TestCase(
    Kaspresso.Builder.withForcedAllureSupport()
) {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun allureTest() {
        run {
            OnboardingScreen {
                step("Нажимает Skip на экране онбординга") {
                    skip {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Если вылез поп ап Вики Геймс") {
                try {
                    ExploreScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
        }
    }
}