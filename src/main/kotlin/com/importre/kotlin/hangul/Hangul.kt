@file:JvmName("Hangul")

package com.importre.kotlin.hangul

/**
 * `null`문자(`'\0'`)를 나타냅니다.
 */
val nullChar = '\u0000'

/**
 * 문자 [char]가 한글인지 확인합니다.
 *
 * @param char 한글인지 확인하려는 문자
 * @return 만일 한글이면 `true`, 그렇지 않으면 `false`를 반환
 */
fun isHangul(char: Char): Boolean = isHangul(char.toInt())

/**
 * 코드 값 [code]가 한글인지 확인합니다.
 *
 * @see isHangul
 *
 * @param code 한글인지 확인하려는 코드 값
 * @return 만일 한글이면 `true`, 그렇지 않으면 `false`를 반환
 */
fun isHangul(code: Int): Boolean = 0xAC00 <= code && code <= 0xD7A3

/**
 * 문자 [char]를 초성, 중성, 종성으로 분리된 문자열을 반환합니다.
 *
 * @param char 초성, 중성, 종성으로 분리하고 하는 문자
 * @param atomic `true`이면 중성과 종성을 더 잘게 분리합니다. 예)`ㄼ`은 `ㄹㅂ`으로, `ㅚ`는 `ㅗㅣ`로
 * @return 초성, 중성, 종성으로 분리된 문자열을 반환합니다.
 */
@JvmOverloads
fun splitAsString(char: Char, atomic: Boolean = false): String {
    val (i, m, f) = split(char) ?: return char.toString()
    val initial = i
    val medial = if (atomic) splitTable[m] ?: m else m
    val final = if (atomic) splitTable[f] ?: f else f
    return "$initial$medial$final".filter { it != nullChar }
}

/**
 * 문자 [char]를 초성, 중성, 종성으로 분리합니다.
 *
 * @see splitAsString
 *
 * @param char 초성, 중성, 종성으로 분리하고 하는 문자
 * @return 초성, 중성, 종성으로 분리된 결과
 */
fun split(char: Char): Triple<Char, Char, Char>? {
    if (!isHangul(char)) {
        return null
    }

    return (char.toInt() - 0xAC00).let {
        var v = it
        val f = v % 28
        v /= 28
        val m = v % 21
        v /= 21
        val i = v % 19
        Triple(initialList[i], medialList[m], finalList[f])
    }
}

/**
 * 문자열 [string]의 자소를 전부 분해합니다.
 *
 * @see split
 *
 * @param string 자소분해를 하고자 하는 문자열
 * @param atomic `true`이면 중성과 종성을 더 잘게 분리합니다. 예)`ㄼ`은 `ㄹㅂ`으로, `ㅚ`는 `ㅗㅣ`로
 * @return 자소분해된 문자열
 */
@JvmOverloads
fun strokes(string: String, atomic: Boolean = false): String = string
        .map { splitAsString(it, atomic) }
        .joinToString("")
