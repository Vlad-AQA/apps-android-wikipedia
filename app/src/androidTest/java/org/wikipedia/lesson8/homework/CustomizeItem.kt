package org.wikipedia.lesson8.homework
import android.view.View
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val handle = KImageView(matcher) {
        withId(R.id.feed_content_type_drag_handle)
    }.name(withParent("Иконка перетаскивания"))

    val title = KTextView(matcher) {
        withId(R.id.feed_content_type_title)
    }.name(withParent("Заголовок"))

    val subTitle = KTextView(matcher) {
        withId(R.id.feed_content_type_subtitle)
    }.name(withParent("Подзаголовок"))

    val switcher = KCheckBox(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }.name(withParent("Свитчер"))


}