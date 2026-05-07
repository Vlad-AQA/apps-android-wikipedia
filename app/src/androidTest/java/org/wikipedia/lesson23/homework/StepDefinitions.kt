package org.wikipedia.lesson23.homework

import android.view.View
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.getByText
import org.wikipedia.lesson21.invokeAtIndexAndClass
import org.wikipedia.lesson24.assertTrimmedTextIsEquals
import org.wikipedia.lesson24.clickIfEnabled
import org.wikipedia.lesson25.CloseGotIt
import org.wikipedia.lesson25.ClosePlayTodayGame
import org.wikipedia.lesson25.PassInterferingScreens

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

    inline fun <reified T : KRecyclerItem<T>> clickItemWithText(
        step: String,
        element: KRecyclerView,
        text: String
    ) {
        execute(step) {
            element.getByText<T>(text).click()
        }
    }

    inline fun <reified T : KRecyclerItem<T>> invokeAtIndexAndClass(
        step: String,
        element: KRecyclerView,
        index: Int,
        clazz: Class<out View>,
        crossinline function: T.() -> Unit
    ) {
        execute(step) {
            element.invokeAtIndexAndClass<T>(index, clazz){ function() }
        }
    }

    private val passInterferingScreens = PassInterferingScreens(
        listOf(
            ClosePlayTodayGame(testContext),
            CloseGotIt(testContext)
        )
    )

    @PublishedApi
    internal fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            try {
                fnc()
            } catch (_: Throwable) {
                passInterferingScreens.execute()
                fnc()
            }
        }
    }

//    @PublishedApi
//    internal fun execute(step: String, fnc: () -> Unit) {
//        testContext.step(step) {
//            try {
//                fnc()
//            } catch (_: Throwable) {
//                ClosePlayTodayGame(testContext).initBehavior()
//                fnc()
//            }
//        }
//    }
}
