package com.tibagni.logviewer.rc

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals

class UIScaleConfigTests {

    @Test
    fun testAutoScale() {
        val config1 = UIScaleConfig("auto")
        val config2 = UIScaleConfig("AUTO")

        assertNotEquals("lower case", UIScaleConfig.SCALE_OFF, config1.configValue)
        assertNotEquals("upper case", UIScaleConfig.SCALE_OFF, config1.configValue)
    }

    @Test
    fun testFixedScale() {
        val config1 = UIScaleConfig("1")
        val config2 = UIScaleConfig("2")
        val config3 = UIScaleConfig("3")
        val config4 = UIScaleConfig("4")

        assertEquals(1, config1.configValue)
        assertEquals(2, config2.configValue)
        assertEquals(3, config3.configValue)
        assertEquals(4, config4.configValue)
    }

    @Test
    fun testInvalidScale() {
        val config1 = UIScaleConfig("")
        val config2 = UIScaleConfig(" ")
        val config3 = UIScaleConfig("a")
        val config4 = UIScaleConfig("0x44")

        assertEquals(UIScaleConfig.SCALE_OFF, config1.configValue)
        assertEquals(UIScaleConfig.SCALE_OFF, config2.configValue)
        assertEquals(UIScaleConfig.SCALE_OFF, config3.configValue)
        assertEquals(UIScaleConfig.SCALE_OFF, config4.configValue)
    }

    @Test
    fun testNegativeScale() {
        val config1 = UIScaleConfig("-4")
        val config2 = UIScaleConfig("-879785")
        val config3 = UIScaleConfig("-123")

        assertEquals(UIScaleConfig.SCALE_OFF, config1.configValue)
        assertEquals(UIScaleConfig.SCALE_OFF, config2.configValue)
        assertEquals(UIScaleConfig.SCALE_OFF, config3.configValue)
    }

    @Test
    fun testZeroScale() {
        val config1 = UIScaleConfig("0")

        assertEquals(UIScaleConfig.SCALE_OFF, config1.configValue)
    }
}