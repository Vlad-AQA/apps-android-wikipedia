package org.wikipedia.lesson19

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson18.getName

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {
    override val self = this

    fun click(element: BaseActions) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun typeText(element: EditableActions, text: String) {
        steps.typeText(
            "Вводит текст '$text' в '${(element as BaseActions).getName()}'",
            element,
            text
        )
    }
}





