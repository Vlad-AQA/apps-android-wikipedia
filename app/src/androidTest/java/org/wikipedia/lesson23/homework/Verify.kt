package org.wikipedia.lesson23.homework

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson24.getName

class Verify(@PublishedApi internal val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Проверяет, что отображается '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' эквивалентен '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${(element as BaseActions).getName()}' содержит подстроку '$text'",
            element,
            text,
            true
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Проверяет, что отображается '${element.getName()}'",
            element
        )
    }

    fun hasText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Проверяет что текст в элементе '${element.getName()}' эквивалентен '$text'",
            element,
            text
        )
    }

    fun assertTrimmedTextIsEquals(element: NodeAssertions, expected: String) {
        steps.assertTrimmedTextIsEquals(
            "Проверяет значение текста без проблеов '${(element as NodeActions).getName()}'",
            element,
            expected
        )
    }
}
