package com.spbu.parseus

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File


class HtmlParser(fileName: String, val charset: String): AbstractParser(fileName){
    override fun getText(): String {
        val html: Document = Jsoup.parse(File(fileName), charset)
        val title = html.title()
        val body = html.body().allElements.text()
        var result = title + "\n" + body
        return result
    }
}