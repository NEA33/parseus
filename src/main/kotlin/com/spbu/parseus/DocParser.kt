package com.spbu.parseus

import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.File
import java.io.FileInputStream


class DocParser(fileName: String): AbstractParser(fileName) {
    override fun getText(): String {
        val fileSystem: POIFSFileSystem = POIFSFileSystem(FileInputStream(File(fileName)))
        val doc: HWPFDocument = HWPFDocument(fileSystem)
        val wordExtractor: WordExtractor = WordExtractor(doc)
        val paragraphs = wordExtractor.paragraphText
        return paragraphs.joinToString(separator = "\n")
    }
}