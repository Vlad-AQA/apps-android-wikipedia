package org.wikipedia.lesson21.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    clazz: Class<out View>,
    limit: Int = 10,
    skipItems: Int = 0,
    name: String = "$index",
    function: T.() -> Unit
) {

}