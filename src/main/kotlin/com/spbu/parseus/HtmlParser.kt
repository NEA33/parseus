package com.spbu.parseus

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File


class HtmlParser(fileName: String): AbstractParser(fileName) {
    private val html: Document
    init {
        if (Regex(""".html""").containsMatchIn(fileName))
            html = Jsoup.parse(File(fileName),"UTF-8")
        else
            html = Jsoup.connect(fileName).get()
    }
    override fun getText(): String {
        val title = html.title()
        val body = html.body().allElements.text()
        var result = title + "\n" + body
        return result
    }
    override fun getLinks(): String {
        val links = html.body().getElementsByTag("a")
            .eachAttr("href").joinToString(separator = "\n")
        return links
    }
}