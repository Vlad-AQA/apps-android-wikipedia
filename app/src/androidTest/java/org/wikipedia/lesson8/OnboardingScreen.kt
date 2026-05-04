package org.wikipedia.lesson8

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher
import  org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView


object AddLanguageScreen : KScreen<AddLanguageScreen>() {
    override val layoutId = null
    override val viewClass = null
}
object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId: Int = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*> = OnboardingPageView::class.java

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
//            itemType(:: PagerItem1)

        }
    )
    val languages = KRecyclerView(
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItems8)
        }
    )
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languageList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItems8)
        }
    )

    val addLanguageButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }

}

class LanguageItems8(matcher: Matcher<View>) : KRecyclerItem<LanguageItems8>(matcher),
    TextViewAssertions


//class PagerItem1(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {
//
//    val image = KImageView(matcher) {
//        withId(R.id.imageViewCentered)
//    }
//
//    val title = KTextView(matcher) {
//        withId(R.id.primaryTextView)
//    }

