package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson8.homework.AnnouncementCard
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.DataItem
import org.wikipedia.lesson8.homework.FeaturedArticle
import org.wikipedia.lesson8.homework.InTheNews
import org.wikipedia.lesson8.homework.OfflineCard
import org.wikipedia.lesson8.homework.SearchItemV2
import org.wikipedia.lesson8.homework.TopRead
import org.wikipedia.lesson18.invokeAtIndex
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

object ExploreScreen : BaseScreen<ExploreScreen>() {

    override val screenName = "Экран экплор"

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Логотип"))

    val closeButton = KImageView {
        withId(R.id.closeButton)
    }.name(withParent(("Кнопка закрыть")))

    val items = KRecyclerView(

        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchItemV2)
            itemType(::CustomizeItem)
            itemType(::DataItem)
            itemType(::TopRead)
            itemType(::InTheNews)
            itemType(::FeaturedArticle)
            itemType(::AnnouncementCard)
            itemType(::OfflineCard)
        }
    ).name(withParent("Блоки экрана экплоре"))
}