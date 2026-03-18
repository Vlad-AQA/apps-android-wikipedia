package org.wikipedia.lesson8.homework

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView


object ArticleCardScreen: KScreen<ArticleCardScreen>() {

    override val layoutId: Int = 0

    override val viewClass: Class<*> = FeedView::class.java


    val retry = KButton {
        withText("Cannot connect to internet")
    }

    val textError = KTextView {
        withText("Cannot connect to internet")
    }

    val webView = KWebView() {
        withId(R.id.page_web_view)
    }

}