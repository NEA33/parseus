package com.spbu.parseus

import org.apache.poi.xwpf.extractor.XWPFWordExtractor
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.File
import java.io.FileInputStream

class DocxParser: Parser {
    private val doc: XWPFDocument
    private val wordExtractor: XWPFWordExtractor

    constructor(path: String) {
        val fileSystem: FileInputStream = FileInputStream(File(path).absolutePath)
        doc = XWPFDocument(fileSystem)
        wordExtractor = XWPFWordExtractor(doc)
    }

    override fun getText(): String = wordExtractor.text

    override fun getLinks(): List<String> {
        val links: MutableList<String> = mutableListOf()
        doc.hyperlinks.forEach { link -> links.add(link.url) }
        return links
    }
}