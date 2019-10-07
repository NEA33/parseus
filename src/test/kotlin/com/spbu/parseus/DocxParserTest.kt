package com.spbu.parseus

import org.junit.Test

class DocxParserTest {
    val path = System.getProperty("user.dir") + "/src/main/resources/test.docx"
    val doc = DocxParser(path)

    @Test
    fun testGetText() = println(doc.text)

    @Test
    fun testGetLinks() = doc.links.forEach { link -> println(link) }
}