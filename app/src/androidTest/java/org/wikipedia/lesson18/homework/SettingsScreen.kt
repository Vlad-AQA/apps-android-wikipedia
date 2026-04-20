package org.wikipedia.lesson18.homework


import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.invokeWithText
import org.wikipedia.lesson18.name


object SettingsScreen : BaseScreen<SettingsScreen>() {
    override val screenName = "Экран Settings"

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.recycler_view)
            },
            itemTypeBuilder = {
                itemType(::SettingsSwitchItem)
                itemType(::TermsOfUseItem)
            }
        ).name(withParent("Блоки экрана Settings"))
    }
    inline fun <reified T : KRecyclerItem<T>> anyOfBlock(
        text: String,
        noinline fnc: T.() -> Unit
    ) {
        items.invokeWithText<T>(text, fnc)
    }
}