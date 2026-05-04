package org.wikipedia.lesson24.homework

import androidx.appcompat.widget.AppCompatImageButton
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.BaseScreen
import org.wikipedia.lesson18.homework.LanguageItems
import org.wikipedia.lesson18.name

object WikiLanguageScreen: BaseScreen<WikiLanguageScreen>() {

    override val screenName = "Экран Wiki добавления языков"
   // лояут часть рецайклера
//    val addLanguageButton = KTextView {
//        withId(R.id.wiki_language_title)
//    }.name(withParent("Кнопка add Language"))

    val wikiLanguagesList = KRecyclerView(
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::LanguageItems)
        }
    ).name(withParent("Спискок языков"))

    val back = KImageView {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }.name(withParent("Кнопка назад"))
}
