package com.spbu.parseus

import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import java.io.FileInputStream

class DocParser(path: String) : Parser {

    private val wordExtractor: WordExtractor

    init {
        val fileSystem = FileInputStream(path)
        val doc = HWPFDocument(fileSystem)
        wordExtractor = WordExtractor(doc)
    }

    override val text: String = wordExtractor.text

    override val links: List<String> = wordExtractor.paragraphText
        .map { it.substringAfter("HYPERLINK \"").substringBefore("\"") }
        .filter { "http" in it }
}