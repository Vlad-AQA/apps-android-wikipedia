package org.wikipedia.lesson28

import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import io.qameta.allure.kotlin.AllureId
import org.junit.Test
import org.wikipedia.BuildConfig
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.LanguageItems
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson23.homework.action
import org.wikipedia.lesson23.homework.verify
import org.wikipedia.lesson24.AddLanguageScreen
import org.wikipedia.lesson24.LanguageItem
import org.wikipedia.lesson24.homework.WikiLanguageScreen
import org.wikipedia.lesson24.invokeWithText

val variant = BuildConfig.DEFAULT_RESTBASE_URI_FORMAT

class TestBuildConfig: BaseTest() {

    @AllureId("4")
    @Test
    fun checkAddLanguage(){
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.clickItemWithText<LanguageItems>(WikiLanguageScreen.wikiLanguagesList,"Add language")
            // препод сказал что экран компоуза должен быть обьектом тогда мы достучимся как к обычному экрану
            // семантики из конструктора класса крина компоуза не нужна так как мы передаем в бейз тест наши  рулы
            onComposeScreen<AddLanguageScreen>(testRule) {
                items.invokeWithText<LanguageItem>(BuildConfig.LANGUAGE){
                    verify.assertTrimmedTextIsEquals(titleLanguage, BuildConfig.LANGUAGE)
                    verify.assertTrimmedTextIsEquals(subtitleLanguage, BuildConfig.CANONICAL_LANGUAGE)
                    action.clickIfEnabled(titleLanguage)
                }
            }
            action.click(WikiLanguageScreen.back)
            OnboardingScreen.languages.childAt<LanguageItems>(2){
                verify.containsText(this,BuildConfig.LANGUAGE)
                verify.isDisplayed(this)
            }

        }
    }

}