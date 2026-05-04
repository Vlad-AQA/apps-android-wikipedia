package org.wikipedia.lesson24.homework

import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson18.name

object WikiLanguageScreen: BaseScreen<OnboardingScreen>() {

    override val screenName = "Экран Wiki добавления языков"
    val addLanguageButton = KTextView {
        withId(R.id.wiki_language_title)
    }.name(withParent("Кнопка add Language"))
}
