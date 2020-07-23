package de.schubert42.zeiterfassung.web.handler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class SeiteExistiertNichtHandler implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange httpServerExchange) {
        httpServerExchange.getResponseHeaders()
                          .put(Headers.CONTENT_TYPE, "text/plain");
        httpServerExchange.setStatusCode(404);
        httpServerExchange.getResponseSender()
                          .send("Seite existiert nicht!");
    }
}
