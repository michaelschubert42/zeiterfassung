package de.schubert42.zeiterfassung.web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class TemplateEngine {

    private Configuration configuration;

    public TemplateEngine() throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setDefaultEncoding("UTF-8");
        //freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);
    }

    public void renderTemplate(String name, Map<String, String> daten, Writer writer) {
        try {
            Template template = configuration.getTemplate(name+".ftlh");
            template.process(daten, writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
