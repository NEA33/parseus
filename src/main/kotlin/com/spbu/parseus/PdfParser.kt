package com.spbu.parseus

import com.itextpdf.text.pdf.parser.PdfTextExtractor
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy
import com.itextpdf.text.pdf.parser.TextExtractionStrategy

class PdfParser(fileName: String): AbstractParser(fileName) {
    override fun getText(): String {
        val reader: com.itextpdf.text.pdf.PdfReader = com.itextpdf.text.pdf.PdfReader(fileName)
        val strategy: TextExtractionStrategy = SimpleTextExtractionStrategy()
        var result = ""
        for (i in 1..reader.numberOfPages)
            result = result + PdfTextExtractor.getTextFromPage(reader, i, strategy) + "\n"
        reader.close()
        return result
    }
}