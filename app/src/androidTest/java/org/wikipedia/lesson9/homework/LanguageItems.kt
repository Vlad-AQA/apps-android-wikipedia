package org.wikipedia.lesson9.homework

import android.view.View

import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageItems(matcher: Matcher<View>) : KRecyclerItem<LanguageItems>(matcher) {

    val language = KTextView(matcher) {
        withId(R.id.option_label)
    }

    val addLanguages = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }
}