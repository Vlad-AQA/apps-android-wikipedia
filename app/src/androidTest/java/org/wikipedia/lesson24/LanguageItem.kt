package org.wikipedia.lesson24

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.hasTestTag
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.extensions.uiTest.Tags.LOCALIZED_LANGUAGE_NAME
import org.wikipedia.compose.extensions.uiTest.Tags.SUBTITLE

class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val titleLanguage by lazy {
        child<KNode>{
            hasTestTag(LOCALIZED_LANGUAGE_NAME)

        }.name(withParent("Заголовок язык локализации"))
    }

    val subtitleLanguage by lazy {
        child<KNode>{
            hasTestTag(SUBTITLE)
        }.name(withParent("Подзаголовок перевод"))
    }
}