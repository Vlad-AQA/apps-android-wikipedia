package org.wikipedia.lesson6

import com.google.android.material.button.MaterialButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import  org.wikipedia.R


object Onboarding : KScreen<Onboarding>() {

    override val layoutId: Int? = null

    override val viewClass: Class<*>? = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }
    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }
    val image = KImageView {
        withId(R.id.imageViewCentered)
    }
    val primaryText = KTextView {
        withId(R.id.primaryTextView)
    }
    val secodaryText = KTextView {
        containsText("found")
    }

    val addLanguages = KButton {
        isDescendantOfA {
            withId(R.id.scrollViewContainer)
        }
        isInstanceOf(MaterialButton::class.java)
    }
    val firstLan = KTextView {
        withIndex(0) {
            withId(R.id.option_label)
        }
    }
    val tabL = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }
}

fun main() {
    Onboarding {
        skipButton {
            click()
            isDisplayed()
        }

        tabL.selectTab(2)

        tabL {
            selectTab(2)
        }

    }
}