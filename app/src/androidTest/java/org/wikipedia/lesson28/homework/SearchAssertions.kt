package org.wikipedia.lesson28.homework

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithText

fun ComposeTestRule.assertNoResultsShown() =
    onNodeWithText("No results found").assertIsDisplayed()

fun ComposeTestRule.assertResultsShown() =
    onNodeWithText("No results found").assertDoesNotExist()
