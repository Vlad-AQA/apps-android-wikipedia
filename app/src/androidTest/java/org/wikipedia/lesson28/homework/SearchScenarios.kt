package org.wikipedia.lesson28.homework

import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson18.homework.SearchItem
import org.wikipedia.lesson18.homework.SearchScreen
import org.wikipedia.lesson20.multiAction

object SearchScenarios {
    fun openSearchAndType(query: String) {
        OnboardingScreen.skipButton.multiAction()
        try {
            ExploreScreen.closeButton.multiAction()
        } catch (_: Exception) {
        }
        ExploreScreen.anyOfBlock<SearchItem>("Search Wikipedia") {
            click()
        }
        SearchScreen.writeTextSearch.typeText(query)
        SearchScreen.search.hasText(query)
    }
}