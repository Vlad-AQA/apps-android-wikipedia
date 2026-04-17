package org.wikipedia.lesson18.homework

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.name

object SearchScreen : BaseScreen<SearchScreen>(){

    override val screenName = "Экран поиска"

    val back by lazy {
        KImageView() {
            withContentDescription("Navigate up")
        }
    }

    val engTab by lazy {
        KTextView {
            withId(R.id.language_label)
            withText("English")
        }.name(withParent("Кнопка английского языка"))
    }

    val ruTab by lazy {
        KTextView {
            withId(R.id.language_label)
            withText("русский")
        }.name(withParent("Кнопка русского языка"))
    }

    val more by lazy {
        KButton {
            withId(R.id.more_languages)
        }.name(withParent("Кнопка больше языков языка"))
    }

    val search by lazy {
        KEditText {
            withId(androidx.appcompat.R.id.search_src_text)
        }.name(withParent("Блок ввода текста"))
    }
    val writeTextSearch by lazy {
        KEditText() {
            withId(androidx.appcompat.R.id.search_src_text)
        }.name(withParent("Ввод текста"))
    }


}