package org.wikipedia.lesson23.homework

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson24.getName

class Actions(@PublishedApi internal val steps: StepDefinitions) : StepsDsl<Actions>() {
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

    fun click(element: KWebViewElement) {
        steps.click("Нажимает на '${element.getName()}'", element)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("click If Enabled '${element.getName()}'", element)
    }

    inline fun <reified T : KRecyclerItem<T>>clickItemWithText(element: KRecyclerView, text: String){
        steps.clickItemWithText<T>("Нажимает на айтем '$text' в '${element.getName()}'", element, text)
    }
}
