package com.spbu.parseus

import org.junit.Test
import java.net.URL

class HtmlParserTest {

    private val path = System.getProperty("user.dir") + "/src/main/resources/test.html"
    private val url = URL("https://www.yandex.ru")

    private val pathDoc = HtmlParser(path)
    private val urlDoc = HtmlParser(url)

    @Test
    fun testGetTextFromPathFile() = println(pathDoc.text)

    @Test
    fun testGetTextFromUrlFile() = println(urlDoc.text)

    @Test
    fun testGetLinksFromPathFile() = pathDoc.links.forEach { link -> println(link) }

    @Test
    fun testGetLinksFromUrlFile() = urlDoc.links.forEach { link -> println(link) }
}