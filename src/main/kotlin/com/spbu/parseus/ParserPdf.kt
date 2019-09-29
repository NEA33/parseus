package com.spbu.parseus

import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy
import com.itextpdf.text.pdf.parser.TextExtractionStrategy

class ParserPdf(val fileName: String): Parser {
    override fun getText(): String {
        val reader: com.itextpdf.text.pdf.PdfReader = com.itextpdf.text.pdf.PdfReader(fileName)
        val strategy: TextExtractionStrategy = SimpleTextExtractionStrategy()
        var tmp = ""
        for (i in 1..reader.numberOfPages)
            tmp = tmp + PdfTextExtractor.getTextFromPage(reader, i, strategy) + '\n'
        reader.close()
        return tmp
    }
}