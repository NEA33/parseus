package com.spbu.parseus

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.net.URL

class HtmlParser : Parser {

    private val html: Document

    constructor (path: String) {
        html = Jsoup.parse(File(path), "UTF-8")
    }

    constructor (url: URL) {
        html = Jsoup.connect(url.toString()).get()
    }

    override val text: String
        get() {
            val title = html.title()
            val body = html.body().allElements.text()
            return title + "\n" + body
        }

    override val links: List<String>
        get() = html.body()
            .getElementsByTag("a")
            .eachAttr("href")
}