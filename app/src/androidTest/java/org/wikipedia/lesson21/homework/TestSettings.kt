package org.wikipedia.lesson21.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson20.multiAction

class TestSettings: BaseTest() {

    @Test
    fun checkSettingsSwitcher() {
        OnboardingScreen.skipButton.multiAction()
        try {
            ExploreScreen.closeButton.multiAction()
        } catch (_: Exception) {
        }
        ExploreScreen.items.invokeAtIndexAndId(){

        }
    }
}