package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val number = KTextView(matcher) {
        withId(R.id.numberView)
    }.name(withParent("Номер"))

    val title = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }.name(withParent("Заголовок"))

    val subtitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }.name(withParent("Подзаголовок"))

    val graph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }.name(withParent("График просмотров"))

    val pageViews = KTextView(matcher) {
        withId(R.id.view_list_card_item_pageviews)
    }.name(withParent("Просмотры"))

    val image = KTextView(matcher) {
        withId(R.id.view_list_card_item_image)
    }.name(withParent("Картинка"))
}