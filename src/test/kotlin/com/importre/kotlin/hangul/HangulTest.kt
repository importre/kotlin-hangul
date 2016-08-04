package com.importre.kotlin.hangul

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HangulTest {

    @Test
    fun shouldBe한글() {
        assertTrue(isHangul('가'))
        assertTrue(isHangul('낣'))
        assertTrue(isHangul('힣'))
    }

    @Test
    fun not한글() {
        assertFalse(isHangul('a'))
        assertFalse(isHangul('2'))
        assertFalse(isHangul('@'))
    }

    @Test
    fun shouldBeSplit() {
        assertEquals(Triple('ㄱ', 'ㅏ', 'ㄺ'), split('갉'))
        assertEquals("ㅎㅓ", splitAsString('허'))
        assertEquals("ㄱㅏㄹㄱ", splitAsString('갉', atomic = true))
        assertEquals("ㄱㅏㄺ", splitAsString('갉'))
    }

    @Test
    fun checkStrokes() {
        assertEquals("Hello World", strokes("Hello World"))
        assertEquals("ㅇㅏㄴㄴㅕㅇㅎㅏㅅㅔㅇㅛ :)", strokes("안녕하세요 :)"))
        assertEquals("ㅇㅜㅇㅗㅏ", strokes("우와", atomic = true))
        assertEquals("ㅇㅜㅇㅘ", strokes("우와"))
    }
}