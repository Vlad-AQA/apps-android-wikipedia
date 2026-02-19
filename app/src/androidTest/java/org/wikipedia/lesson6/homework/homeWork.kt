package org.wikipedia.lesson6.homework


import androidx.appcompat.widget.AppCompatImageView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import  org.wikipedia.R


object Theme : KScreen<Theme>() {

    override val layoutId: Int? = null

    override val viewClass: Class<*>? = null


    val readingText = KTextView {
        withId(R.id.textSettingsCategory)
    }

    val sizePercent = KTextView {
        withId(R.id.text_size_percent)
    }

    //системный элемент не тестируется
//    val closeOverlay = KView {
//        isDescendantOfA {
//            withId(R.id.container)
//        }
//        withIndex(1){
//            isInstanceOf(View::class.java)
//        }
//    }

    val buttonTextSizeMinus = KTextView {
        withId(R.id.buttonDecreaseTextSize)
    }

    val seekBar = KSeekBar {
        withId(R.id.text_size_seek_bar)
    }

    val buttonTextSizePlus = KTextView {
        withId(R.id.buttonIncreaseTextSize)
    }

    val sensSerif = KButton {
        withId(R.id.button_font_family_sans_serif)
    }

    val serif = KButton {
        withId(R.id.button_font_family_serif)
    }

    val glasses = KImageView {
        isDescendantOfA {
            withId(R.id.readingFocusModeContainer)
        }
        isInstanceOf(AppCompatImageView::class.java)
    }

    val focusMode = KSwitch {
        withId(R.id.theme_chooser_reading_focus_mode_switch)
    }

    val themeChooser = KTextView {
        withId(R.id.theme_chooser_reading_focus_mode_description)
    }
    val themeText = KTextView {
        isDescendantOfA {
            withId(R.id.font_change_progress_bar)
        }
        containsText("Theme")
    }
    val themeLight = KButton {
        withId(R.id.button_theme_light)
    }
    val themeSepia = KButton {
        withId(R.id.button_theme_sepia)
    }
    val themeDark = KButton {
        withId(R.id.button_theme_dark)
    }
    val themeBlack = KButton {
        withId(R.id.button_theme_black)
    }

    val mathSystemTheme = KSwitch {
        withId(R.id.theme_chooser_match_system_theme_switch)
    }
    val imageDimmingDarkTheme = KSwitch {
        withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    }


}