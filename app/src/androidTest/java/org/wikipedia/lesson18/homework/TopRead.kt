package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson8.homework.TopReadItem

class TopRead(matcher: Matcher<View>) : KRecyclerItem<TopRead>(matcher) {

    val menu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }
    }
    val headerTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }
    }

    val topRead by lazy {
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }
    }


    val items by lazy {
        KRecyclerView(
            matcher,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadItem)

            }
        )
    }
}