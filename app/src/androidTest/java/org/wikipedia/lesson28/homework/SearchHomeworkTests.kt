package org.wikipedia.lesson28.homework

import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import io.qameta.allure.kotlin.AllureId
import org.wikipedia.lesson18.homework.BaseTest

class SearchHomeworkTests : BaseTest() {

    @get:Rule(order = 3)
    val searchDataRule = SearchDataRule()

    @Test
    @AllureId("1")
    @Description("valid")
    fun validQueryShowsResults() {
        SearchScenarios.openSearchAndType(searchDataRule.testData)
        testRule.assertResultsShown()

    }

    @Test
    @AllureId("2")
    @Description("invalid")
    fun invalidQueryShowsNoResults() {
        SearchScenarios.openSearchAndType(searchDataRule.testData)
        testRule.assertNoResultsShown()
    }

    @Test
    @AllureId("3")
    @Description("not_in_list")
    fun anotherInvalidQueryShowsNoResults() {
        SearchScenarios.openSearchAndType(searchDataRule.testData)
        testRule.assertNoResultsShown()
    }

}
