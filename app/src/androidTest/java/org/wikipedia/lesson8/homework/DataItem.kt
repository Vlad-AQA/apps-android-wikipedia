package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DataItem(matcher: Matcher<View>) : KRecyclerItem<DataItem>(matcher) {

    val data = KTextView(matcher) {
        withId(R.id.day_header_text)
    }

}