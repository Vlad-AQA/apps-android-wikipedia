package org.wikipedia.lesson9.homework

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

class LanguageScreen : KScreen<LanguageScreen>() {

    override val layoutId: Int = 0
    override val viewClass: Class<*> = Any::class.java

    val back = KImageView {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val title = KTextView{
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatTextView::class.java)
    }

    val menu = KImageView {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        withContentDescription("More options")
    }







}