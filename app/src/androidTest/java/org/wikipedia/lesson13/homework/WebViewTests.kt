package org.wikipedia.lesson13.homework

import androidx.compose.ui.test.hasText
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson13.WebScreen
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson8.homework.SearchItemV2
import org.wikipedia.lesson8.homework.TopRead
import org.wikipedia.lesson8.homework.TopReadItem
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity


class WebViewTests : TestCase(
    Kaspresso.Builder.withForcedAllureSupport()
) {

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
            step("Клик по поиску") {
                ExploreScreen {
                    items {
                        childWith<SearchItemV2> {
                            withDescendant { withContentDescription("Search Wikipedia") }
                        } perform {
                            textSearch.click()
                        }
                    }
                }
            }
            step("Пишем в поиске spider man") {
                SearchScreen.search.typeText("spider man")
            }
            step("Тап по первой статье") {
                device.uiDevice.findObject(UiSelector().text("Spider-Man")).click()
                //закрыли вики геймс
                try {
                    ExploreScreen.closeButton.click()
                } catch (_: Exception) {
                }
            }
            step("Скролим до References проверяем текст") {
                WebScreen.webView {
                    withElement(Locator.ID, "References") {
                        scroll()
                        hasText("References")
                    }
                }
            }
            step("Скролим до 5й ссылки и тапаем") {
                WebScreen.webView {
                    withElement(
                        Locator.XPATH,
                        "//sup[contains(@class,'mw-ref')]//span[text()=5]"
                    ) {
                        scroll()
                        click()
                        Thread.sleep(3000)
                    }
                }
            }
            step("Проверили заголовок") {
                ReferencesScreen.title.hasText("Reference ")
            }
            step("Проверяем что ссылка под номером 5") {
                ReferencesScreen.refId.hasText("5.")
            }
            step("Тап на бек") {
                device.uiDevice.pressBack()
            }
            step("Нашли 2ю ссылку с CSS=mw-redirect нажали на нее"){
                WebScreen.webView{
                    withElement(Locator.XPATH,"//*[@id=\"pcs\"]/section[1]/p[4]/a[24]"){
                        scroll()
                        click()
                    }
                }
            }
            step("Тап на Read article"){
                ActionModeBareScreen.readArticleButton.click()
            }
        }
    }
}