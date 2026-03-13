package org.wikipedia.lesson11.homework

import androidx.compose.ui.text.intl.Locale
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson8.homework.ArticleCardScreen
import org.wikipedia.lesson8.homework.ExploreScreen
import org.wikipedia.lesson8.homework.FeaturedArticle
import org.wikipedia.lesson8.homework.OfflineCard
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity


class AdbTestsV2class : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkRetry() {
        before("Проверка работы без сети") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
            Thread.sleep(3000)
            OnboardingScreen.skip.click()
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
            Thread.sleep(3000)
        }.run {
            step("Перешли в Featured Article") {
                ExploreScreen {
                    items {
                        childWith<FeaturedArticle> {
                        } perform {
                            contentTitle.click()
                        }
                    }
                }
            }
            step("Проверили Retry и текст ошибки") {
                ArticleCardScreen {
                    retry.isDisplayed()
                    textError.isDisplayed()
                }
            }
            step("Включили сеть") {
                adbServer.performAdb("shell svc data enable")
                adbServer.performAdb("shell svc wifi enable")
                Thread.sleep(3000)
            }
            step("Тап на Retry") {
                ArticleCardScreen {
                    retry.click()
                }
            }
        }
    }

    @Test
    fun checkLanguage() {
        run {
            OnboardingScreen {
                step("Проверили что скип на английском") {
                    skip { hasText("Skip") }
                }
                step("Сменили язык") {
                    device.uiDevice.executeShellCommand("settings put system system_locales ru-Ru")
                    Thread.sleep(3000)
                    device.uiDevice.executeShellCommand("am start -n org.wikipedia.alpha/.main.MainActivity")
                    Thread.sleep(3000)
                }
                step("Проверили что скип сменился на Пропустить") {
                    skip { hasText("Пропустить") }
                }

            }
        }
    }
}