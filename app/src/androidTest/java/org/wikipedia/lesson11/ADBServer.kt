package org.wikipedia.lesson11

import android.view.Surface
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test



import org.wikipedia.lesson8.homework.TopRead
import org.wikipedia.lesson9.homework.OnboardingScreen
import org.wikipedia.main.MainActivity

class ADBServer : TestCase() {

    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkADB() {
        // Сохраняем текст в файл на девайсе
// аналог это adb shell 'echo "Hello from Kaspresso" > /sdcard/kaspresso_test.txt'
        adbServer.performShell(
            command = "echo",
            arguments = listOf(
                "Hello from Kaspresso",
                ">",
                "/sdcard/kaspresso_test.txt"
            )
        )

// Скачиваем файл с девайса на ПК
// аналог это adb pull //sdcard/kaspresso_test.txt ./kaspresso_test.txt
        adbServer.performAdb(
            command = "pull",
            arguments = listOf(
                "/sdcard/kaspresso_test.txt",
                "./kaspresso_test.txt"
            )
        )
    }

    @Test
    fun preAndPostScenario() {
        before("Название теста") {
            adbServer.performAdb("shell svc data disable")
            adbServer.performAdb("shell svc wifi disable")
        }.after {
            adbServer.performAdb("shell svc data enable")
            adbServer.performAdb("shell svc wifi enable")
        }.run {
            OnboardingScreen {
                skip.click()
                Thread.sleep(10000)
            }
        }
    }

    @Test
    fun checkAdb() {
        run {
            device.uiDevice.setOrientationRight()
            Thread.sleep(3000)
            val act = device.uiDevice.getDisplayRotation()
            repeat(3) {
                device.uiDevice.setOrientationRight()
                Thread.sleep(3000)
                device.uiDevice.setOrientationNatural()
                Thread.sleep(3000)
            }
            val ex = Surface.ROTATION_270
            Assert.assertEquals(ex,act)

            adbServer.performAdb("shell svc data disable")

            adbServer.performAdb("shell svc data enable")

            adbServer.performAdb("shell svc wifi enable")

            adbServer.performAdb("shell svc wifi disable")

        }


    }

}