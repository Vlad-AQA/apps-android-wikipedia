package org.wikipedia.lesson8.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.lesson8.SearchItem
import org.wikipedia.R
class SearchItem1(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon = KImageView(matcher) {
        withIndex(0) {
            isDescendantOfA { AppCompatImageView::class.java }
        }
    }

    val text = KTextView(matcher){
        withText(R.string.search_hint)
    }

    val voiceIcon = KImageView(matcher) {
        withId(R.id.voice_search_button)
    }
}