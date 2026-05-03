package org.wikipedia.lesson23.homework

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.intercept.operation.ComposeAction
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson24.assertTrimmedTextIsEquals
import org.wikipedia.lesson24.clickIfEnabled

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun typeText(step: String, element: EditableActions, text: String) {
        execute(step) {
            element.typeText(text)
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction { scroll() }
        }
    }

    fun click(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction {
                scroll()
                click()
            }
        }
    }

    fun hasText(step: String, element: KWebViewElement, text: String) {
        execute(step) {
            element.performWebViewAction {
                scroll()
                hasText(text)
            }
        }
    }

    fun clickIfEnabled(step: String, element: NodeActions) {
        execute(step) {
            element.clickIfEnabled()
        }

    }
    fun assertTrimmedTextIsEquals(step: String, element: NodeAssertions, expected: String) {
        execute(step) {
            element.assertTrimmedTextIsEquals(expected)
        }

    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            fnc()
        }
    }
}
