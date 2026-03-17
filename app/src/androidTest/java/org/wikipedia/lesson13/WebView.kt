package org.wikipedia.lesson13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.wikipedia.main.MainActivity

class WebView : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    fun checkWebView() {
        run {
            ArticalWebScreen {
                webView {
                    withElement(Locator.CLASS_NAME, "mw-page-title-main") {
                        scroll()
                        hasText("Corleck Head")
                    }
                    withElement(Locator.XPATH,"//*[@id=\"pcs\"]/section[1]/div/div[2]/table/tbody/tr[2]/td/span/a/img") {
                        scroll()
                        click()
                    }
                }
            }
        }
    }
}