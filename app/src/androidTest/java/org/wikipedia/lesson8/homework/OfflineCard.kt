package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OfflineCard(matcher: Matcher<View>) : KRecyclerItem<OfflineCard>(matcher) {

    val retry = KButton(matcher) {
        withId(R.id.view_card_offline_button_retry)
    }

    val textError = KTextView(matcher) {
        withText("Content cannot be loaded when offline")
    }
}