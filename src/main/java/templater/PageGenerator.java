package templater;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    public static final String HTML_DIR = "templates";
    public static final Configuration CFG = new Configuration(Configuration.VERSION_2_3_22);
//    public static final Configuration CFG = new Configuration();

    private static void setConfiguration() throws IOException {
        File dir = new File(HTML_DIR);
        TemplateLoader templateLoader = new FileTemplateLoader(dir);
        CFG.setTemplateLoader(templateLoader);
    }

    public static String getPage(String filename, Map<String, Object> data) throws IOException {
        setConfiguration();
        Writer stream = new StringWriter();
        try {
            Template template = CFG.getTemplate(filename + ".ftl");
            template.process(data, stream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stream.toString();
    }

}
