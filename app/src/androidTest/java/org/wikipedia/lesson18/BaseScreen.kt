package org.wikipedia.lesson18

import com.kaspersky.kaspresso.screens.KScreen
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen.pager
import org.wikipedia.lesson8.PagerItem
import org.wikipedia.lesson18.homework.ExploreScreen.items

abstract class BaseScreen <T : BaseScreen<T>> : KScreen<T>() {

    override val layoutId = null
    override val viewClass = null
    abstract val screenName: String
    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }
    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
    // В OnboardinScreen можем добавить обёртку для доступа к слайдам
    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }

}