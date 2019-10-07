package com.spbu.parseus

import org.apache.commons.lang.text.StrTokenizer
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

class ParserTest {

    private val root = System.getProperty("user.dir") + "/src/test/resources/"

    private val docParser: Parser = DocParser(root + "test.doc")
    private val docxParser: Parser = DocxParser(root + "test.docx")
    private val htmlParser: Parser = HtmlParser(root + "test.html")
    private val pdfParser: Parser = PdfParser(root + "test.pdf")

    @Test
    fun testLinksAreEqualForAllFormats() {
        val expected = listOf(
            "http://www.foxege.ru/",
            "https://vk.com/ege_oge_fox",
            "https://yandex.ru/maps/-/CGssAKlK"
        )

        assertEquals(expected, docParser.links.sorted())
        assertEquals(expected, docxParser.links.sorted())
        assertEquals(expected, htmlParser.links.sorted())
        assertEquals(expected, pdfParser.links.sorted())
    }

    @Ignore
    @Test
    fun testTextsAreTheSameForAllFormats() {
        val input = "Добрый день!\n" +
                "Добро пожаловать в центр для подготовки к ОГЭ и ЕГЭ Мудрый Лис (https://vk.com/ege_oge_fox).\n" +
                "Мудрый Лис предлагает:\n" +
                "- подготовка к ОГЭ для 9 класса по математике и физике\n" +
                "- подготовка к ЕГЭ для 11 класса по математике (база, профиль) и физике\n" +
                "Занятия проходят в оборудованном кабинете по адресу: " +
                "м. Кировский завод, ул. Зайцева, д. 41 (https://yandex.ru/maps/-/CGssAKlK)\n" +
                "www.foxege.ru"

        val tokenizer = StrTokenizer(input)
        val expected = tokenizer.tokenList

        assertEquals(expected, StrTokenizer(docParser.text).tokenList)
        assertEquals(expected, StrTokenizer(docxParser.text).tokenList)
        assertEquals(expected, StrTokenizer(htmlParser.text).tokenList)
        assertEquals(expected, StrTokenizer(pdfParser.text).tokenList)
    }
}