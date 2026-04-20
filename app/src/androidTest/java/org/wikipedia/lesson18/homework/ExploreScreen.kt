package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson8.homework.AnnouncementCard
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.DataItem
import org.wikipedia.lesson8.homework.FeaturedArticle
import org.wikipedia.lesson8.homework.InTheNews
import org.wikipedia.lesson8.homework.OfflineCard
import org.wikipedia.lesson8.homework.TopRead
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.name


object ExploreScreen : BaseScreen<ExploreScreen>() {

    override val screenName = "Экран экплор"

    val logo by lazy {
        KImageView {
            withId(R.id.main_toolbar_wordmark)
        }.name(withParent("Логотип"))
    }

    val closeButton by lazy {
        KImageView {
            withId(R.id.closeButton)
        }.name(withParent(("Кнопка закрыть")))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::SearchItem)
                itemType(::CustomizeItem)
                itemType(::DataItem)
                itemType(::TopRead)
                itemType(::InTheNews)
                itemType(::FeaturedArticle)
                itemType(::AnnouncementCard)
                itemType(::OfflineCard)
            }
        ).name(withParent("Блоки экрана эксплор"))
    }

    val moreTab by lazy {
        KView {
            withContentDescription("More")
        }.name(withParent("Таб More"))
    }

    val iconMoreTab by lazy {
        KImageView {
            withId(com.google.android.material.R.id.navigation_bar_item_icon_view)
            isDescendantOfA{withContentDescription("More")}
        }.name(withParent("Иконка таба More"))
    }

    fun customizeBlock(fnc: CustomizeItem.() -> Unit) {
        items.invokeWithText("Customize", fnc )
    }

    fun topReadBlock(fnc: TopRead.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }

    inline fun <reified T : KRecyclerItem<T>> anyOfBlock(
        text: String,
        noinline fnc: T.() -> Unit
    ) {
        items.invokeWithText<T>(text, fnc)
    }


}
