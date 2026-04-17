package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name

object MoreScreen : BaseScreen<MoreScreen>() {
    override val screenName = "Экран меню More"

    val textSettings by lazy {
        KTextView(){
            withText("Settings")
        }.name(withParent("Текст 'Settings' на кнопке Settings"))
    }

}