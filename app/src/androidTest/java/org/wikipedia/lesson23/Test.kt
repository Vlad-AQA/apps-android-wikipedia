package org.wikipedia.lesson23


import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson19.action
import org.wikipedia.lesson19.verify
import org.wikipedia.lesson8.homework.TopReadItem

class Test : BaseTest() {

    @Test
    fun test() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                items.childAt<TopReadItem>(0, {
                    action.click(this)
                    Thread.sleep(3000)
                })
            }
//            ArticleScreen{
//                title.performWebViewAction {
//                    scroll()
//
//                }
            verify.isDisplayed(ArticleScreen.title)
        }
    }
}
