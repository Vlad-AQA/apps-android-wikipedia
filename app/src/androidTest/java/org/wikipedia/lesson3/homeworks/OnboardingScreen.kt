package org.wikipedia.lesson3.homeworks

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.button.MaterialButton
import org.wikipedia.R
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_skip_button,
    R.string.onboarding_skip
)

val continueButton = listOf(
    MaterialButton::class.java,
    R.id.fragment_onboarding_done_button,
    R.string.onboarding_continue
)

val imageCentered = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

val primaryText = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_welcome_title_v2
)

val secondaryText = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_multilingual_secondary_text
)

val optionLabel = listOf(
    AppTextView::class.java,
    R.id.option_label
)

val languageButton = listOf(
    MaterialButton::class.java,
    R.id.addLanguageButton,
    R.string.onboarding_multilingual_add_language_text
)

// Нажали на continue

val imageCentered1 = listOf(
    AppCompatImageView::class.java,
    R.id.imageViewCentered
)

val primaryText1 = listOf(
    AppTextView::class.java,
    R.id.primaryTextView,
    R.string.onboarding_explore_title
)

val secondaryText1 = listOf(
    AppTextView::class.java,
    R.id.secondaryTextView,
    R.string.onboarding_explore_text
)

