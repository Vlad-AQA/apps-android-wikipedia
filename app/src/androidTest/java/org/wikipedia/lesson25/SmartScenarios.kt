package org.wikipedia.lesson25

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class SmartScenarios(private val testContext: TestContext<*>) {

    fun closePlayTodayGame() = ClosePlayTodayGame(testContext).initBehavior()

    fun closeGotIt() = CloseGotIt(testContext).initBehavior()
}
