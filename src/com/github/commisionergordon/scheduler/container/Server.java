package com.github.commisionergordon.scheduler.container;

import com.github.commisionergordon.scheduler.servlet.DatePrintServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/*
For some reason, the server.isRunning() boolean is never changed. Could be
a thread thing, but I have no idea. All the things that depend on server.isRunning()
have been commented out.
*/

public class Server {
    
    private static final String TITLE = "Scheduler Server";
    
    private int port = 1337;
    private boolean running;
    private Tomcat tomcat;
    
    public Server() {
        tomcat = new Tomcat();
        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = tomcat.addContext("/app", base.getAbsolutePath());
        Tomcat.addServlet(rootCtx, "dateServlet", new DatePrintServlet());
        rootCtx.addServletMapping("/date", "dateServlet");
        running = false;
    }
    
    public void start() throws LifecycleException {
        System.out.println();
        System.out.println("Starting Tomcat Server on port " + port);
        tomcat.setPort(port);
        tomcat.start();
        tomcat.getServer().await();
        running = true;
    }
    
    public void stop() throws LifecycleException {
        System.out.println();
        System.out.println("Stopping Tomcat Server...");
        tomcat.stop();
        running = false;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int port) {
        System.out.println("Setting Tomcat Server port to " + port);
        this.port = port;
    }
    
    public boolean isRunning() {
        return running;
    }
}
