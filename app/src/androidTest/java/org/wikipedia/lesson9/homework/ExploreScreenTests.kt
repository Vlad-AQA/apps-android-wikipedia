package org.wikipedia.lesson9.homework

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import  com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson8.homework.AnnouncementCard
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson8.homework.FeaturedArticle
import org.wikipedia.main.MainActivity


class ExploreScreenTests : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun chekExploreScreen() {
        run {
            OnboardingScreen {
                step("Нажимает Skip на экране онбординга") {
                    skip {
                        isDisplayed()
                        click()
                    }
                }
            }
            ExploreScreen {
                step("Проверяет отображение блока Featured Article экрана Explore") {
                    items {
                        childWith<FeaturedArticle> {
                            hasText("Featured article") // не обязательно в данном конексте у меня единственый такой айтем FeaturedArticle
                        } perform {
                            image {
                                isDisplayed()
                            }
                            contentTitle {
                                isDisplayed()
                            }
                            contentText {
                                isDisplayed()
                            }
                        }
                    }
                    items {
                        step("Нажимает на кнопку Customize") {
                            childWith<AnnouncementCard> {} perform {
                                customize {
                                    isDisplayed()
                                    click()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


