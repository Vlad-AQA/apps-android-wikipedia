package org.wikipedia.lesson24.homework


import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import org.wikipedia.lesson18.homework.BaseTest
import org.junit.Test
import org.wikipedia.lesson23.homework.action
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson23.homework.verify
import org.wikipedia.lesson24.AddLanguageScreen
import org.wikipedia.lesson24.LanguageItem
import org.wikipedia.lesson24.invokeWithText

class Test: BaseTest() {

    @Test
    fun checkAddLanguage(){
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.click(WikiLanguageScreen.addLanguageButton)
            onComposeScreen<AddLanguageScreen>(testRule) {
                items.invokeWithText<LanguageItem>("Deutsch"){
                    verify.assertTrimmedTextIsEquals(titleLanguage, "Deutsch")
                    verify.assertTrimmedTextIsEquals(subtitleLanguage, "German")
                }
            }

        }
    }

}