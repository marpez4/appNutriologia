package com.example.appnutriologia

import org.junit.Assert.assertEquals
import org.junit.Test

class FlavorsTest {

    @Test
    fun `validate COLOR_NAV for dev flavor`() {
        assertEquals(0xFF388E3C.toInt(), BuildConfig.COLOR_NAV)
    }
/**
    @Test
    fun `validate COLOR_NAV for qa flavor`() {
        assertEquals(0xFFFF9800.toInt(), BuildConfig.COLOR_NAV)
    }

    @Test
    fun `validate COLOR_NAV for pro flavor`() {
        assertEquals(0xFF66BB6A.toInt(), BuildConfig.COLOR_NAV)
    }
    **/
}