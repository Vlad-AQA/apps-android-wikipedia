package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val number = KTextView(matcher) {
        withId(R.id.numberView)
    }
    val title = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }
    val subtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }
    val graph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }
    val pageViews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }
    val image = KTextView(matcher) {
        withId(R.id.view_list_card_item_image)
    }
}