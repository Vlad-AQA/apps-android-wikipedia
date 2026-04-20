package org.wikipedia.lesson21.homework

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson18.getName
import org.wikipedia.lesson18.name
import org.wikipedia.lesson21.hasClassOrChildWithClass
import org.wikipedia.lesson21.hasIdOrChildWithId

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndId(
    index: Int,
    itemId: Int,
    limit: Int = 10,
    skipItems: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {
    val recycler = this
    var currentIndex = 0
    var isElementFoundByIndex = false
    val lastIndex = (limit + skipItems).coerceAtMost(getSize()) - 1
    val firstIndex = skipItems.coerceAtMost(lastIndex)
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementContainsView = this.hasIdOrChildWithId(itemId)
            if (isElementContainsView && index == currentIndex++) {
                isElementFoundByIndex = true
                name(recycler.getName().withParent(name))
                function()
            }
        }
        if (isElementFoundByIndex) break
    }
    if (!isElementFoundByIndex) {
        throw IllegalStateException("Элемент с индексом $index в пределах ${lastIndex + 1} элементов не найден")
    }

}