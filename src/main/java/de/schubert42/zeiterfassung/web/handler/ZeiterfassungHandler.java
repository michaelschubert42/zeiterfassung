package de.schubert42.zeiterfassung.web.handler;

import de.schubert42.zeiterfassung.web.TemplateEngine;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ZeiterfassungHandler implements HttpHandler {
    private TemplateEngine templateEngine;
    private String uhrzeit;

    public ZeiterfassungHandler(TemplateEngine templateEngine, String uhrzeit) {
        this.templateEngine = templateEngine;
        this.uhrzeit = uhrzeit;
    }

    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) {
        httpServerExchange.getResponseHeaders()
                          .put(Headers.CONTENT_TYPE, "text/html");
        StringWriter stringWriter = new StringWriter();
        Map<String, String> daten = new HashMap<>();
        daten.put("uhrzeit", uhrzeit);
        templateEngine.renderTemplate("zeiterfassung", daten, stringWriter);

        httpServerExchange.getResponseSender()
                          .send(stringWriter.toString());

    }
}
