package com.lgcns.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class MyServer {
	

    public void start() throws Exception {

        Server server = new Server();

        ServerConnector http = new ServerConnector(server);

        http.setHost("127.0.0.1");

        http.setPort(8080);

        server.addConnector(http);

        ServletHandler servletHandler = new ServletHandler();

        servletHandler.addServletWithMapping(MyServlet.class, "/*");

        server.setHandler(servletHandler);


        server.start();

        server.join();

    }
}
