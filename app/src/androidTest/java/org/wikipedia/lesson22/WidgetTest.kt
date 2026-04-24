package org.wikipedia.lesson22

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson19.action
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.verify

class WidgetTest: BaseTest() {

    @Test
    fun checkSearchWidget() {
        run {
            action.click(OnboardingScreen.skipButton)
            verify{
                ExploreScreen.searchWidget {
                    isDisplayed(this)
                    isDisplayed(searchIcon)
                    hasText(searchText, "Search Wikipedia")
                    isDisplayed(searchVoiceIcon)
                }
            }
        }
    }
}