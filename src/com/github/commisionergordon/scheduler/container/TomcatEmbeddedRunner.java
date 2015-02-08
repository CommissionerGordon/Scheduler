package com.github.commisionergordon.scheduler.container;

import com.github.commisionergordon.scheduler.servlet.DatePrintServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Context;

import java.io.File;

/**
 * Created by Kyle on 2/7/2015.
 */
public class TomcatEmbeddedRunner {

    public void startServer() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(1337);
        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = tomcat.addContext("/app", base.getAbsolutePath());
        Tomcat.addServlet(rootCtx, "dateServlet", new DatePrintServlet());
        rootCtx.addServletMapping("/date", "dateServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
