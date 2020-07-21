package de.schubert42.zeiterfassung;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class Main {
    public static void main(String[] args) {
        Undertow server = Undertow.builder().addHttpListener(8080,
                "localhost").setHandler(exchange -> {
            exchange.getResponseHeaders()
                    .put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getResponseSender().send("Zeiterfassung");
        }).build();
        server.start();
    }
}
