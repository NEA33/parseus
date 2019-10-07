package com.spbu.parseus

import com.itextpdf.text.pdf.*
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy
import com.itextpdf.text.pdf.parser.TextExtractionStrategy
import java.net.URL

class PdfParser: Parser {
    private val reader: PdfReader

    constructor(url: URL) {
        reader = PdfReader(url.toString())
    }

    constructor(path: String) {
        reader = PdfReader("file://" + path)
    }

    override fun getText(): String {
        val strategy = SimpleTextExtractionStrategy()
        var result = ""
        for (i in 1..reader.numberOfPages)
            result = result + PdfTextExtractor.getTextFromPage(reader, i, strategy) + "\n"
        reader.close()
        return result
    }

    override fun getLinks(): List<String> {
        var listLinks: MutableList<String> = mutableListOf()
        for (i in 1..reader.numberOfPages) {
            val linksPage = reader.getLinks(i)
            if (linksPage != null) {
                for (link in linksPage) {
                    val clearLink = link.toString().substringAfter("/URI:").substringBefore(" ")
                    if ("http" in clearLink) {
                        listLinks.add(clearLink)
                    }
                }
            }
        }
        return listLinks
    }
}