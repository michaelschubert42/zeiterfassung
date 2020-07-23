package de.schubert42.zeiterfassung;

import de.schubert42.zeiterfassung.web.TemplateEngine;
import de.schubert42.zeiterfassung.web.Webserver;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String uhrzeit = "00:00:00 Uhr";
        if (args.length > 0) {
            uhrzeit = args[0];
        }

        try {
            new Webserver("localhost", 8080, new TemplateEngine(), uhrzeit).starten();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
