package org.wikipedia.lesson8.homework

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object Customize: KScreen<Customize>() {

    override val layoutId: Int = 0

    override val viewClass: Class<*> = FeedView::class.java


    val back = KImageView() {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val title = KTextView() {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatTextView::class.java)
    }

    val menu = KImageView() {
        withContentDescription("More options")
    }



    val items =  KRecyclerView(

        builder = {
            withId(R.id.content_types_recycler)
        },
        itemTypeBuilder = {
           itemType(::CustomizeItem)
        }
    )

}