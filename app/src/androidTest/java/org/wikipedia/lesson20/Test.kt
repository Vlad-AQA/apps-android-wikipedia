package org.wikipedia.lesson20

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.OnboardingScreen

class  Test() : BaseTest() {


    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen.skipButton.multiAction()
        }
    }

    @Test
    fun assertionTest() {
        run {
            OnboardingScreen.page(1) {
                title.equalsWithTrim("New ways to explore")
            }
        }
    }
}