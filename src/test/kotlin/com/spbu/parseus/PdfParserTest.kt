package com.spbu.parseus

import org.junit.Test
import java.net.URL

class PdfParserTest {

    private val path = System.getProperty("user.dir") + "/src/main/resources/test.pdf"
    private val url = URL("https://www.tutorialspoint.com/kotlin/kotlin_tutorial.pdf")

    private val pathDoc = PdfParser(path)
    private val urlDoc = PdfParser(url)

    @Test
    fun testGetTextFromPathFile() = println(pathDoc.text)

    @Test
    fun testGetTextFromUrlFile() = println(urlDoc.text)

    @Test
    fun testGetLinksFromPathFile() = pathDoc.links.forEach { link -> println(link) }

    @Test
    fun testGetLinksFromUrlFile() = urlDoc.links.forEach { link -> println(link) }
}