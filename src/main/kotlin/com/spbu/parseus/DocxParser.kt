package com.spbu.parseus

import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import java.io.File

class DocxParser(fileName: String): AbstractParser(fileName) {
    override fun getText(): String {
        val wordMLPackage: WordprocessingMLPackage = WordprocessingMLPackage.load(File(fileName))
        return wordMLPackage.mainDocumentPart.content.joinToString(separator = "\n")
    }
}