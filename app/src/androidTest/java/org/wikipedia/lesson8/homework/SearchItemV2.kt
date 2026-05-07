package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class SearchItemV2(matcher: Matcher<View>) : KRecyclerItem<SearchItemV2>(matcher) {

    val icon = KImageView(matcher) {
        withContentDescription("Search Wikipedia")
    }.name(withParent("Иконка поиска"))

    val textSearch = KTextView(matcher){
        withText(R.string.search_hint)
    }.name(withParent("Плейсхолдер поиска"))

    val writeTextSearch = KEditText() {
        withId(androidx.appcompat.R.id.search_src_text)
    }.name(withParent("Поле ввода"))

    val voiceIcon = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }.name(withParent("Иконка голосового поиска"))
}