package org.wikipedia.lesson18.homework

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.lesson18.name
import org.wikipedia.lesson18.withParent

class TermsOfUseItem(matcher: Matcher<View>) : KRecyclerItem<TermsOfUseItem>(matcher) {

    val title by lazy {
        KTextView(matcher){
            withId(android.R.id.title)
        }.name(withParent("Заголовок"))
    }
     val icon by lazy {
         KImageView(matcher){
             withId(R.id.right_icon)
         }.name(withParent("Картинка"))
     }

}