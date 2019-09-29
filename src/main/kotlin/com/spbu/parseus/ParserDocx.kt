package com.spbu.parseus

import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import java.io.File

class ParserDocx(val fileName: String): Parser {
    override fun getText(): String {
        val wordMLPackage: WordprocessingMLPackage = WordprocessingMLPackage.load(File(fileName))
        var tmp = ""
        for (i in wordMLPackage.mainDocumentPart.content)
            tmp = tmp + i + '\n'
        return tmp
    }
}