package com.spbu.parseus

import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import org.apache.poi.poifs.filesystem.POIFSFileSystem
import java.io.File
import java.io.FileInputStream


class ParserDoc(val fileName: String): Parser {
    override fun getText(): String {
        val fs: POIFSFileSystem = POIFSFileSystem(FileInputStream(File(fileName)))
        val doc: HWPFDocument = HWPFDocument(fs)
        val we: WordExtractor = WordExtractor(doc)
        val paragraphs = we.paragraphText
        var tmp = ""
        for (i in paragraphs)
            tmp = tmp + i + '\n'
        return tmp
    }
}