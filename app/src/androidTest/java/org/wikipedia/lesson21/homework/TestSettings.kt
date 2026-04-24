package org.wikipedia.lesson21.homework

import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson18.homework.SettingsScreen
import org.wikipedia.lesson18.homework.SettingsSwitchItem
import org.wikipedia.lesson18.homework.TermsOfUseItem
import org.wikipedia.lesson19.homework.MoreMenuScreen
import org.wikipedia.lesson20.multiAction

class TestSettings : BaseTest() {

    @Test
    fun checkSettingsSwitcher() {
        run {
            OnboardingScreen.skipButton.multiAction()
            try {
                ExploreScreen.closeButton.multiAction()
            } catch (_: Exception) {
            }
            ExploreScreen.moreTab.multiAction()
            MoreMenuScreen.settingsButton.multiAction()
            SettingsScreen.items.invokeAtIndexAndId<SettingsSwitchItem>(1, R.id.switchWidget) {
                try {
                    switcher.isNotChecked()
                } catch (_: Throwable) {
                    switcher.multiAction()
                }
                switcher.multiAction()
                switcher.isChecked()
            }
            //завернуть в метод на экране айтема
            SettingsScreen.items.invokeAtIndexAndId<TermsOfUseItem>(2, R.id.right_icon, 50) {
                title.hasText("Terms of use")
            }


        }
    }
}