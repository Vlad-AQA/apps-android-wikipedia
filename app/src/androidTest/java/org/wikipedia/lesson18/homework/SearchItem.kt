package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent


class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher){

    val icon = KImageView(matcher) {
        withContentDescription("Search Wikipedia")
    }.name(withParent("Иконка поиска"))

    val textSearch = KTextView(matcher){
        withText(R.string.search_hint)
    }.name(withParent("Teкст Search Wikipedia на блоке поиска"))

    val writeTextSearch = KEditText() {
        withId(androidx.appcompat.R.id.search_src_text)
    }.name(withParent("Поле ввода текста"))

    val voiceIcon = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }.name(withParent("Иконка голосового поиска"))

}