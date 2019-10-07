package com.spbu.parseus

import org.junit.Test

class HtmlParserTest {
    val path = System.getProperty("user.dir") + "/src/main/resources/test.html"
    val doc = HtmlParser(path)

    @Test
    fun testGetText() = println(doc.text)

    @Test
    fun testGetLinks() = doc.links.forEach { link -> println(link) }
}