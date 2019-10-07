package com.spbu.parseus

import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import java.io.File
import java.io.FileInputStream


class DocParser: Parser {
    private val wordExtractor: WordExtractor

    constructor(path: String) {
        val fileSystem = FileInputStream(File(path).absolutePath)
        val doc = HWPFDocument(fileSystem)
        wordExtractor = WordExtractor(doc)
    }

    override fun getText(): String = wordExtractor.text

    override fun getLinks(): List<String> {
        var listLinks: MutableList<String> = mutableListOf()
        var clearLink: String
        wordExtractor.paragraphText.forEach { s ->
            run {
                clearLink = s.substringAfter("HYPERLINK \"").substringBefore(("\""))
                if ("http" in clearLink)
                    listLinks.add(clearLink)
            }
        }
        return listLinks
    }
}