package com.spbu.parseus

import com.itextpdf.text.pdf.*
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy
import com.itextpdf.text.pdf.parser.TextExtractionStrategy
import java.net.URL

class PdfParser(url: String): AbstractParser(url) {
    private val reader: PdfReader
    init {
        reader = PdfReader(URL(url))
    }

    override fun getText(): String {
        val strategy: TextExtractionStrategy = SimpleTextExtractionStrategy()
        var result = ""
        for (i in 1..reader.numberOfPages)
            result = result + PdfTextExtractor.getTextFromPage(reader, i, strategy) + "\n"
        reader.close()
        return result
    }

    override fun getLinks(): List<String> {
        var listLinks: MutableList<String> = mutableListOf()
        var k = 0
        for (i in 1..reader.numberOfPages) {
            val linksPage = reader.getLinks(i)
            if (linksPage != null) {
                for (link in linksPage) {
                    val clearLink = link.toString().substringAfter("/URI:").substringBefore(" ")
                    if ("http" in clearLink) {
                        listLinks.add(k, clearLink)
                        k += 1
                    }
                }
            }
        }
        return listLinks
    }
}