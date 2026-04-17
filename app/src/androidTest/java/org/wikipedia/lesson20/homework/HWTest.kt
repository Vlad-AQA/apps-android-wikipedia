package org.wikipedia.lesson20.homework

import org.junit.Test
import org.wikipedia.lesson18.homework.BaseTest
import org.wikipedia.lesson18.homework.OnboardingScreen
import org.wikipedia.lesson20.multiAction
import org.wikipedia.lesson18.homework.ExploreScreen
import org.wikipedia.lesson18.homework.MoreScreen
import org.wikipedia.lesson18.homework.SearchItem
import org.wikipedia.lesson18.homework.SearchScreen
import org.wikipedia.lesson18.homework.SettingsScreen
import org.wikipedia.lesson18.homework.SettingsSwitchItem

class HWTest: BaseTest() {

    @Test
    fun e2e() {
        OnboardingScreen.skipButton.multiAction()
        try {
            ExploreScreen.closeButton.multiAction()
        } catch (_: Exception) {
        }
        ExploreScreen.anyOfBlock<SearchItem>("Search Wikipedia") {
            click()
        }
        SearchScreen.writeTextSearch.multiAction()
        SearchScreen.search.hasText("On")
        device.uiDevice.pressBack()
        device.uiDevice.pressBack()
        ExploreScreen.moreTab.multiAction()
        MoreScreen.textSettings.multiAction()
        SettingsScreen.anyOfBlock<SettingsSwitchItem>("Download only over Wi-Fi"){
            try {
                switcher.isNotChecked()
            } catch (_: Exception) {
                switcher.multiAction()
            }
            switcher.multiAction()
            switcher.isChecked()
        }





    }
}