package org.wikipedia.lesson22


import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.R
import org.wikipedia.lesson18.name

object SearchTollBarScreen: BaseScreen<SearchTollBarScreen>() {
    override val screenName = "Экран поиска нижнего тулбара"

    val searchWidget by lazy {
        SearchWidget{
            withId(R.id.search_card)
        }.name(withParent("Виджет поиска"))
    }

    val noRecentlyWidget by lazy {
        NoRecentlyWidget{
            withId(R.id.history_empty_container)
        }.name(withParent("Виджет пустого экрана поиска"))
    }
}