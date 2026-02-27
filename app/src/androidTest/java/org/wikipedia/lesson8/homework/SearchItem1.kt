package org.wikipedia.lesson8.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.lesson8.SearchItem

class SearchItem1 (matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon = KImageView(matcher) {
        isDescendantOfA { AppCompatImageView::class.java }
        isDisplayed()
    }

}