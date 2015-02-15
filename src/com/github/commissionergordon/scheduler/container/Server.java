package com.github.commissionergordon.scheduler.container;

import com.github.commissionergordon.scheduler.servlet.CSSPageServlet;
import com.github.commissionergordon.scheduler.servlet.DatePrintServlet;
import com.github.commissionergordon.scheduler.servlet.HomePageServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

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

        Tomcat.addServlet(rootCtx, "homePageServlet", new HomePageServlet());
        rootCtx.addServletMapping("/home", "homePageServlet");

        Tomcat.addServlet(rootCtx, "CSSPageServlet", new CSSPageServlet());
        rootCtx.addServletMapping("/default-template.css", "CSSPageServlet");

        running = false;
    }
    
    public void start() throws LifecycleException {
        System.out.println();
        System.out.println("Starting Tomcat Server on port " + port);
        running = true;
        
        // All initialization should be done before the tomcat object is touched
        tomcat.setPort(port);
        tomcat.start();
        tomcat.getServer().await();
    }
    
    public void stop() throws LifecycleException {
        System.out.println();
        System.out.println("Stopping Tomcat Server...");
        running = false;
        
        // All objects must be stopped before tomcat is touched
        tomcat.stop();
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
