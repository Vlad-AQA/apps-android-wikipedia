package org.wikipedia.lesson8.homework

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name

object ExploreScreen : BaseScreen<ExploreScreen>() {

    override val screenName = "Экран Explore"

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Логотип"))

    val closeButton = KImageView {
        withId(R.id.closeButton)
    }.name(withParent("Кнопка закрытия"))

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
    ).name(withParent("Лента"))
}
