package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.name
import org.wikipedia.lesson8.homework.AnnouncementCard
import org.wikipedia.lesson8.homework.CustomizeItem
import org.wikipedia.lesson8.homework.DataItem
import org.wikipedia.lesson8.homework.FeaturedArticle
import org.wikipedia.lesson8.homework.InTheNews
import org.wikipedia.lesson8.homework.OfflineCard
import org.wikipedia.lesson8.homework.TopRead

object SettingsScreen : BaseScreen<SettingsScreen>() {
    override val screenName = "Экран Settings"

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::SettingsSwitchItem)

            }
        ).name(withParent("Блоки экрана Settings"))
    }
    inline fun <reified T : KRecyclerItem<T>> anyOfBlock(
        text: String,
        noinline fnc: T.() -> Unit
    ) {
        ExploreScreen.items.invokeWithText<T>(text, fnc)
    }
}