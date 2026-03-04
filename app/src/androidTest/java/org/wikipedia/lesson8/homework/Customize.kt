package org.wikipedia.lesson8.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class Customize(matcher: Matcher<View>) : KRecyclerItem<Customize>(matcher) {

    val back = KImageView(matcher) {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val title = KTextView(matcher) {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatTextView::class.java)
    }

    val menu = KImageView(matcher) {
        withContentDescription("More options")
    }



    val items =  KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
           itemType(::CustomizeItem)
        }
    )
}