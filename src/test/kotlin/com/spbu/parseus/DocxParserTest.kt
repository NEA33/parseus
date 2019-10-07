package com.spbu.parseus

import org.junit.Test

class DocxParserTest {

    private val path = System.getProperty("user.dir") + "/src/main/resources/test.docx"
    private val doc = DocxParser(path)

    @Test
    fun testGetText() = println(doc.text)

    @Test
    fun testGetLinks() = doc.links.forEach { link -> println(link) }
}