package com.importre.kotlin.hangul

internal val initialList = charArrayOf(
        'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ',
        'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
)

internal val medialList = charArrayOf(
        'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ',
        'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'
)

internal val finalList = charArrayOf(
        nullChar, 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ',
        'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ',
        'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
)

internal val splitTable = mapOf(
        'ㅘ' to "ㅗㅏ",
        'ㅙ' to "ㅗㅐ",
        'ㅚ' to "ㅗㅣ",
        'ㅝ' to "ㅜㅓ",
        'ㅞ' to "ㅜㅔ",
        'ㅟ' to "ㅜㅣ",
        'ㅢ' to "ㅡㅣ",
        'ㄵ' to "ㄴㅈ",
        'ㄺ' to "ㄹㄱ",
        'ㄻ' to "ㄹㅁ",
        'ㄼ' to "ㄹㅂ",
        'ㄽ' to "ㄹㅅ",
        'ㄾ' to "ㄹㅌ",
        'ㄿ' to "ㄹㅍ",
        'ㅀ' to "ㄹㅎ",
        'ㅄ' to "ㅂㅅ"
)
