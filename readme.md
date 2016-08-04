# kotlin-hangul

[![Download][bintray-badge]][bintray-version]
[![Build Status][travis-badge]][travis-url]

> :kr: 한글관련 유틸

## Install

### build.gradle

```gradle
repositories {
    jcenter()
}

dependencies {
    compile "com.importre:kotlin-hangul:<VERSION>"
}
```


## APIs

- 문자가 한글인지 아닌지 확인
    - `isHangul`
- 문자/문자열 자소분해
    - `split`
    - `splitAsString`
    - `strokes`

## Usage

### Kotlin

```kotlin
assertTrue(isHangul('가'))
assertTrue(isHangul('낣'))
assertTrue(isHangul('힣'))

assertFalse(isHangul('a'))
assertFalse(isHangul('2'))
assertFalse(isHangul('@'))

assertEquals(Triple('ㄱ', 'ㅏ', 'ㄺ'), split('갉'))
assertEquals("ㅎㅓ", splitAsString('허'))
assertEquals("ㄱㅏㄹㄱ", splitAsString('갉', atomic = true))
assertEquals("ㄱㅏㄺ", splitAsString('갉'))

assertEquals("Hello World", strokes("Hello World"))
assertEquals("ㅇㅏㄴㄴㅕㅇㅎㅏㅅㅔㅇㅛ :)", strokes("안녕하세요 :)"))
assertEquals("ㅇㅜㅇㅗㅏ", strokes("우와", atomic = true))
assertEquals("ㅇㅜㅇㅘ", strokes("우와"))
```

### Java

```java
assertTrue(Hangul.isHangul('가'));
assertTrue(Hangul.isHangul('낣'));
assertTrue(Hangul.isHangul('힣'));

assertFalse(Hangul.isHangul('a'));
assertFalse(Hangul.isHangul('2'));
assertFalse(Hangul.isHangul('@'));

assertEquals(new Triple<>('ㄱ', 'ㅏ', 'ㄺ'), Hangul.split('갉'));
assertEquals("ㅎㅓ", Hangul.splitAsString('허'));
assertEquals("ㄱㅏㄹㄱ", Hangul.splitAsString('갉', true));
assertEquals("ㄱㅏㄺ", Hangul.splitAsString('갉'));

assertEquals("Hello World", Hangul.strokes("Hello World"));
assertEquals("ㅇㅏㄴㄴㅕㅇㅎㅏㅅㅔㅇㅛ :)", Hangul.strokes("안녕하세요 :)"));
assertEquals("ㅇㅜㅇㅗㅏ", Hangul.strokes("우와", true));
assertEquals("ㅇㅜㅇㅘ", Hangul.strokes("우와"));
```


## Test

```sh
$ ./gradlew check
```


## License

Apache 2.0 © Jaewe Heo


[bintray-badge]: https://api.bintray.com/packages/importre/maven/kotlin-hangul/images/download.svg
[bintray-version]: https://bintray.com/importre/maven/kotlin-hangul/_latestVersion
[travis-badge]: https://travis-ci.org/importre/kotlin-hangul.svg?branch=master
[travis-url]: https://travis-ci.org/importre/kotlin-hangul
