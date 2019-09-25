package com.spbu.parseus;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class JsoupTest {

    private String url = "https://en.wikipedia.org/wiki/Queue_(abstract_data_type)";
    private Document document;

    @Test
    public void testGetText() throws IOException {
        document = Jsoup.connect(url).get();

        String text = document.select("p,h1,h2,h3,h4,h5,h6,li").stream()
                .map(Element::text)
                .collect(Collectors.joining("\n"));
        System.out.println(text);

    }

    @Test
    public void testGetInternalLinks() throws IOException {
        document = Jsoup.connect(url).get();
        final String host = URI.create(url).getHost();

        final List<String> links = document.select("a").stream()
                .map(element -> element.attr("abs:href"))
                .filter(element -> !element.isEmpty() && element.contains("//" + host))
                .collect(Collectors.toList());

        links.forEach(System.out::println);
    }

    @Test
    public void testGetExternalLinks() throws IOException {
        document = Jsoup.connect(url).get();
        final String host = URI.create(url).getHost();

        final List<String> links = document.select("a").stream()
                .map(element -> element.attr("abs:href"))
                .filter(element -> !element.isEmpty() && !element.contains("//" + host))
                .collect(Collectors.toList());

        links.forEach(System.out::println);
    }
}
