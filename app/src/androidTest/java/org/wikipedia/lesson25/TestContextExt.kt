package org.wikipedia.lesson25

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

val TestContext<*>.smartScenarios: SmartScenarios
    get() = SmartScenarios(this)