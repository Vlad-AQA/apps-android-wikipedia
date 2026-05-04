package org.wikipedia.lesson24

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.ComposeScreen
import org.wikipedia.lesson18.NameHierarchy

abstract class ComposeNamedScreenBase<T : ComposeScreen<T>>(
    semanticsProvider: SemanticsNodeInteractionsProvider
) : ComposeScreen<T>(semanticsProvider) {

    abstract val screenName: String

    private val nameHierarchy by lazy {
        NameHierarchy(screenName)
    }

    fun withParent(name: String): NameHierarchy {
        return NameHierarchy(name, nameHierarchy)
    }
}