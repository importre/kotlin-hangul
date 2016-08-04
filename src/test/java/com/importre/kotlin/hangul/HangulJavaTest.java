package com.importre.kotlin.hangul;

import kotlin.Triple;
import org.junit.Test;

import static org.junit.Assert.*;

public class HangulJavaTest {

    @Test
    public void shouldBe한글() {
        assertTrue(Hangul.isHangul('가'));
        assertTrue(Hangul.isHangul('낣'));
        assertTrue(Hangul.isHangul('힣'));
    }

    @Test
    public void not한글() {
        assertFalse(Hangul.isHangul('a'));
        assertFalse(Hangul.isHangul('2'));
        assertFalse(Hangul.isHangul('@'));
    }

    @Test
    public void shouldBeSplit() {
        assertEquals(new Triple<>('ㄱ', 'ㅏ', 'ㄺ'), Hangul.split('갉'));
        assertEquals("ㅎㅓ", Hangul.splitAsString('허'));
        assertEquals("ㄱㅏㄹㄱ", Hangul.splitAsString('갉', true));
        assertEquals("ㄱㅏㄺ", Hangul.splitAsString('갉'));
    }

    @Test
    public void checkStrokes() {
        assertEquals("Hello World", Hangul.strokes("Hello World"));
        assertEquals("ㅇㅏㄴㄴㅕㅇㅎㅏㅅㅔㅇㅛ :)", Hangul.strokes("안녕하세요 :)"));
        assertEquals("ㅇㅜㅇㅗㅏ", Hangul.strokes("우와", true));
        assertEquals("ㅇㅜㅇㅘ", Hangul.strokes("우와"));
    }
}
