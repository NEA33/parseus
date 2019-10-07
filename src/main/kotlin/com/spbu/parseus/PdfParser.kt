package com.spbu.parseus

import com.itextpdf.text.pdf.*
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy
import java.net.URL

class PdfParser : Parser {

    private val reader: PdfReader

    constructor(url: URL) {
        reader = PdfReader(url.toString())
    }

    constructor(path: String) {
        reader = PdfReader(path)
    }

    override val text: String
        get() = (1..reader.numberOfPages)
            .joinToString("\n") { i ->
                PdfTextExtractor.getTextFromPage(reader, i, SimpleTextExtractionStrategy())
            }

    override val links: List<String>
        get() = (1..reader.numberOfPages)
            .mapNotNull { i -> reader.getLinks(i) }
            .flatten()
            .map { link -> link.toString().substringAfter("/URI:").substringBefore(" ") }
            .filter { "http" in it }
}