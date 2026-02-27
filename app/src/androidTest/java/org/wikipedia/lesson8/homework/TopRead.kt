package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopRead(matcher: Matcher<View>) : KRecyclerItem<TopRead>(matcher) {

    val items = KRecyclerView(
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadItem)

        }
    )
}