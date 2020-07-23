package de.schubert42.zeiterfassung.web.handler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class UebersichtHandler  implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) {
        httpServerExchange.getResponseHeaders()
                          .put(Headers.CONTENT_TYPE, "text/html");
        httpServerExchange.getResponseSender()
                          .send("<!doctype html>\n" +
                                  "<html lang=\"en\">\n" +
                                  "  <head>\n" +
                                  "    <meta charset=\"utf-8\">\n"+
                                  "</head>\n"+
                                  "<body>\n"+
                                  "<h1>Übersicht</h1>\n"+
                                  "</body>\n"+
                                  "</html>");
    }
}
