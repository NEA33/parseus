package com.spbu.parseus


import org.junit.Test
import java.net.URL

class PdfParserTest {
    val path = System.getProperty("user.dir") + "/src/main/resources/test.pdf"
    //val path = URL("https://www.tutorialspoint.com/kotlin/kotlin_tutorial.pdf")
    val doc = PdfParser(path)

    @Test
    fun testGetText() = println(doc.text)

    @Test
    fun testGetLinks() = doc.links.forEach { link -> println(link) }
}