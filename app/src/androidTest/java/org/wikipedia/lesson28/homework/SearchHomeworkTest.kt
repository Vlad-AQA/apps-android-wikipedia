package org.wikipedia.lesson28.homework

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson18.homework.SearchItem
import org.wikipedia.lesson18.homework.SearchScreen
import org.wikipedia.lesson20.multiAction
import io.qameta.allure.kotlin.AllureId

class SearchHomeworkTest : org.wikipedia.lesson18.homework.BaseTest() {

    @get:Rule(order = 3)
    val searchDataRule = SearchDataRule()

    @Test
    @AllureId("1")
    @Description("valid")
    fun validQueryShowsResults() {
        searchScenarioWithResults()
    }

    @Test
    @AllureId("2")
    @Description("invalid")
    fun invalidQueryShowsNoResults() {
        searchScenarioWithoutResults()
    }

    @Test
    @AllureId("3")
    @Description("not_in_list")
    fun anotherInvalidQueryShowsNoResults() {
        searchScenarioWithoutResults()
    }

    private fun searchScenarioWithResults() {
        openSearchAndType(searchDataRule.testData)
        SearchScreen.search.hasText(searchDataRule.testData)
        testRule.onNodeWithText("No results found").assertDoesNotExist()
    }

    private fun searchScenarioWithoutResults() {
        openSearchAndType(searchDataRule.testData)
        SearchScreen.search.hasText(searchDataRule.testData)
        testRule.onNodeWithText("No results found").assertIsDisplayed()
    }

    private fun openSearchAndType(query: String) {
        OnboardingScreen.skipButton.multiAction()
        try {
            ExploreScreen.closeButton.multiAction()
        } catch (_: Exception) {
        }
        ExploreScreen.anyOfBlock<SearchItem>("Search Wikipedia") {
            click()
        }
        SearchScreen.writeTextSearch.typeText(query)
    }
}
