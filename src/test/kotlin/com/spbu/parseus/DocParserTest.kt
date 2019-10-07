package com.spbu.parseus

import org.junit.Test

class DocParserTest {

    private val path = System.getProperty("user.dir") + "/src/main/resources/test.doc"
    private val doc = DocParser(path)

    @Test
    fun testGetText() = println(doc.text)

    @Test
    fun testGetLinks() = doc.links.forEach { link -> println(link) }
}