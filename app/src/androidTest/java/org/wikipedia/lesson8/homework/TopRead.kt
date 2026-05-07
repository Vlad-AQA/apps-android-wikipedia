package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class TopRead(matcher: Matcher<View>) : KRecyclerItem<TopRead>(matcher) {

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }.name(withParent("Иконка меню"))

    val headerTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }.name(withParent("Заголовок"))

    val topRead = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }.name(withParent("Кнопка topRead"))


    val items = KRecyclerView(
         matcher,
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadItem)

        }
    ).name(withParent("Список топ статей"))
}