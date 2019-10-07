package com.spbu.parseus

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.net.URL


 class HtmlParser: Parser {
    private val html: Document

    constructor (path: String) {
        html = Jsoup.parse(File(path), "UTF-8")
    }

    constructor (url: URL) {
        html = Jsoup.connect(url.toString()).get()
    }


    override fun getText(): String {
        val title = html.title()
        val body = html.body().allElements.text()
        return title + "\n" + body
    }

    override fun getLinks(): List<String> = html.body().getElementsByTag("a")
            .eachAttr("href")
}