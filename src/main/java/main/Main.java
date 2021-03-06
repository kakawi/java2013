package main;

import frontend.Frontend;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(frontend), "/");
        context.addServlet(Frontend.class, "/");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
