package com.spbu.parseus

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File


class ParserHtml(val fileName: String, val charset: String): Parser {
    override fun getText(): String {
        val html: Document = Jsoup.parse(File(fileName), charset)
        val title = html.title()
        val body = html.body().allElements.text()
        var tmp = title + '\n' + body
        return tmp
    }
}