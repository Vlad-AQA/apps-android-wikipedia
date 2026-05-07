package org.wikipedia.lesson8.homework

import android.view.View

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class AnnouncementCard(matcher: Matcher<View>) : KRecyclerItem<AnnouncementCard>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }.name(withParent("Картинка"))

    val text = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }.name(withParent("Текст"))

    val customize = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }.name(withParent("Кнопка Customize"))

    val gotIt = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }.name(withParent("Кнопка Got It"))
}