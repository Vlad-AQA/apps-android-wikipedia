package org.wikipedia.lesson22

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class NoRecentlyWidget(builder: ViewBuilder.() -> Unit) : KWidget<NoRecentlyWidget>(builder) {

    val image by lazy {
        KImageView(matcher){
            withId(R.id.history_empty_image)
        }.name(withParent("Картинка"))
    }

    val title by lazy{
        KTextView(matcher){
            withId(R.id.history_empty_title)
        }.name(withParent("Заголовок"))
    }


}