package com.spbu.parseus

import org.junit.Test
import java.net.URL

class HtmlParserTest {
    val path = System.getProperty("user.dir") + "/src/main/resources/test.html"
    //val path = URL("https://www.yandex.ru")
    val doc = HtmlParser(path)

    @Test
    fun testGetText() = println(doc.text)

    @Test
    fun testGetLinks() = doc.links.forEach { link -> println(link) }
}