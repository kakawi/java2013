package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator {
    public static final String HTML_DIR = "templates";
//    public static final Configuration CFG = new Configuration(Configuration.VERSION_2_3_22);
    public static final Configuration CFG = new Configuration();

    public static String getPage(String filename, Map<String, Object> data) {
        Writer stream = new StringWriter();
        try {
            Template template = CFG.getTemplate(HTML_DIR + File.separator + filename + ".ftl");
            template.process(data, stream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stream.toString();
    }

}
