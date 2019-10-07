package com.spbu.parseus

import org.apache.poi.xwpf.extractor.XWPFWordExtractor
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.FileInputStream

class DocxParser(path: String) : Parser {

    private val doc: XWPFDocument
    private val wordExtractor: XWPFWordExtractor

    init {
        val fileSystem = FileInputStream(path)
        doc = XWPFDocument(fileSystem)
        wordExtractor = XWPFWordExtractor(doc)
    }

    override val text: String = wordExtractor.text

    override val links: List<String> = doc.hyperlinks.map { it.url }
}