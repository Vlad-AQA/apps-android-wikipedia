package org.wikipedia.lesson25.homework

import org.junit.Test
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson23.homework.verify
import org.wikipedia.lesson23.homework.ArticleScreen
import org.wikipedia.lesson23.homework.action
import org.wikipedia.lesson8.homework.FeaturedArticle

class TestClose: BaseTest() {

    @Test
    fun closeBannersTest(){
        run{
            action.click(OnboardingScreen.skipButton)
            action.invokeAtIndexAndClass<FeaturedArticle>(
                ExploreScreen.items,
                0,
                FeaturedArticleCardView::class.java
            ){
                action.click(this)
            }
            verify.isDisplayed(ArticleScreen.image)
        }
    }
}//FeaturedArticleCardView