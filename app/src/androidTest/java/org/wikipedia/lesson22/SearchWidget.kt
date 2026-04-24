package org.wikipedia.lesson22

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.builders.ViewBuilder

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent


class SearchWidget(builder: ViewBuilder.() -> Unit) : KWidget<SearchWidget>(builder) {

    val searchIcon by lazy {
        KImageView(matcher) {
            withContentDescription("Search Wikipedia")
        }.name(withParent("иконка поиска"))
    }

    val searchText by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("текст поиска"))
    }

    val searchVoiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("иконка поиска"))
    }


}