package org.wikipedia.lesson24

import org.wikipedia.compose.extensions.uiTest.Tags.LANGUAGE_LIST

class AddLanguageScreen : ComposeNamedScreenBase<AddLanguageScreen>() {
    override val screenName = "Компоуз экран добавления языков"

    val items by lazy {
        createLazyList(
            {
                hasTestTag(LANGUAGE_LIST)
            },
            {itemType(::LanguageItem)}
        )
    }


}