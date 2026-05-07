package org.wikipedia.lesson8.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class FeaturedArticle(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticle>(matcher) {

    val title = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }.name(withParent("заголовок"))

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }.name(withParent("Иконка меню"))

    val image = KImageView(matcher) {
        withId(R.id.articleImage)
    }.name(withParent("Картинка статьи"))

    val contentTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }.name(withParent("Заголовок статьи"))

    val contentDescription = KTextView(matcher) {
        withId(R.id.articleDescription)
    }.name(withParent("Описание статьи"))

    val contentText = KTextView(matcher) {
        withId(R.id.articleExtract)
    }.name(withParent("Текст превью"))

    val toDay = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }.name(withParent("Кнопка На сегодня"))

    val retry = KButton(matcher) {
        withId(R.id.view_card_offline_button_retry)
    }.name(withParent("Кнопка retry"))

    val textError = KTextView(matcher) {
        withText("Content cannot be loaded when offline")
    }.name(withParent("Текст ошибки"))


}