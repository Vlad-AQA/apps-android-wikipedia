package org.wikipedia.lesson19

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson18.homework.TopRead

class DslTest : BaseTest() {

    @Test
    fun example() {
        run {
            val steps = StepDefinitions(this)
            val action = Actions(steps)
            val verify = Verify(steps)
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.anyOfBlock<TopRead>("Top read"){
                verify.isDisplayed(this)
            }
        }
    }



    @Test
    fun example1() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.customizeBlock {
                verify.isDisplayed(this)
            }
        }
    }

}