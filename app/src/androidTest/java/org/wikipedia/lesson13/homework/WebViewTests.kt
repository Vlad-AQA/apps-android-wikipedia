package org.wikipedia.lesson13.homework

import androidx.compose.ui.test.hasText
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.WebScreen
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson8.homework.TopRead
import org.wikipedia.lesson8.homework.TopReadItem
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class WebViewTests : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkWebViewV2() {
        run {
            OnboardingScreen {
                step("Нажимает Skip на экране онбординга") {
                    skip {
                        isDisplayed()
                        click()
                    }
                }
            }
            step("Если вылез поп ап Вики Геймс") {
                try {
                    ExploreScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
            step("Перешли вo 2-ю статью самого читаемого") {
                ExploreScreen {
                    items {
                        childWith<TopRead> {
                            withDescendant { withText("Самое читаемое") }
                        } perform {
                            items {
                                childAt<TopReadItem>(1) {
                                    title.click()
                                }
                            }
                        }
                    }
                }
            }
            step("Скролим до References") {
                WebScreen.webView{
                    withElement(Locator.ID,"References"){
                        scroll()
                    }
                    step("Проверяем текст"){
                        hasText("References")
                    }
                    step("Идем до 5-й ссылки через xpath") {
                        withElement(Locator.XPATH,"//*[@id=\"cite_ref-RitschelMichallon2022_5-1\"]/a/span"){
                            scroll()
                            click()
                            Thread.sleep(3000)
                        }
                    }
                    step("Проверяем ReferencesScreen"){
                        ReferencesScreen.title.hasText("Reference")
                        ReferencesScreen.refId.hasText("5")
                    }
                }
            }
        }
    }

}