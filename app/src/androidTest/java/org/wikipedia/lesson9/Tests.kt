package org.wikipedia.lesson9

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.news.NewsCardView
import org.wikipedia.lesson6.Onboarding.continueButton
import org.wikipedia.lesson6.Onboarding.skipButton
import org.wikipedia.lesson8.ExploreScreen
import org.wikipedia.lesson8.OnboardingScreen
import org.wikipedia.lesson8.homework.InTheNews
import org.wikipedia.lesson8.homework.InTheNewsItem
import org.wikipedia.main.MainActivity
import kotlin.jvm.java

class SimpleTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    // тестовые методы
    @Test
    fun checkOnboardingScreen() {
        run("SimpleTest") {
            OnboardingScreen {
                step("Проверяет что кнопка Skip отображается") {
                    skipButton {
                        isDisplayed()
                        hasText("Skip")
                    }
                }
                step("Нажимает на кнопку Continue") {
                    continueButton {
                        click()
                    }
                }
            }
        }
    }

    @Test
    fun checkExploreScreen() = run {
        OnboardingScreen {
            step("Нажали на кнопку скип") {
                skipButton.click()
            }
            ExploreScreen.items.childWith<InTheNews> {
                isInstanceOf(NewsCardView::class.java)
            } perform {
                headerText.hasText("In the news")
                items.childAt<InTheNewsItem>(2) {
                    image.isDisplayed()
                }
            }
        }
    }
}


