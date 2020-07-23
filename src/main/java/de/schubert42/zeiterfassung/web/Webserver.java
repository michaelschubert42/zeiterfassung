package de.schubert42.zeiterfassung.web;

import de.schubert42.zeiterfassung.web.handler.SeiteExistiertNichtHandler;
import de.schubert42.zeiterfassung.web.handler.UebersichtHandler;
import de.schubert42.zeiterfassung.web.handler.ZeiterfassungHandler;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.server.HttpHandler;

public class Webserver {
    private String host;
    private int port;
    private TemplateEngine templateEngine;
    private String uhrzeit;

    public Webserver(String host, int port, TemplateEngine templateEngine, String uhrzeit) {
        this.host = host;
        this.port = port;
        this.templateEngine = templateEngine;
        this.uhrzeit = uhrzeit;
    }

    public void starten() {
        Undertow.builder()
                .addHttpListener(port, host)
                .setServerOption(UndertowOptions.URL_CHARSET, "UTF8")
                .setHandler(handlerConfiguration())
                .build()
                .start();
    }

    private HttpHandler handlerConfiguration() {
        return Handlers.routing()
                       .get("zeiterfassung/uebersicht", new UebersichtHandler())
                       .get("zeiterfassung", new ZeiterfassungHandler(templateEngine,uhrzeit))
                       .setFallbackHandler(new SeiteExistiertNichtHandler());
    }
}
