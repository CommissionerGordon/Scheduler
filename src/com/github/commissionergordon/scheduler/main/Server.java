package com.github.commissionergordon.scheduler.main;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class Server {
    
    private static final String TITLE = "Scheduler Server";
    private final String webappDir = "webapp/";
    
    private int port = 1337;
    private boolean running;
    private Tomcat tomcat;
    
    public Server() throws ServletException {
        tomcat = new Tomcat();
        tomcat.addWebapp("", new File(webappDir).getAbsolutePath());

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
