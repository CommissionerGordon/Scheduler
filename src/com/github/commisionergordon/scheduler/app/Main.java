package com.github.commisionergordon.scheduler.app;

import com.github.commisionergordon.scheduler.container.TomcatEmbeddedRunner;
import org.apache.catalina.LifecycleException;

import java.io.IOException;

/**
 * Created by Kyle on 2/7/2015.
 */
public class Main {

    public static void main(String[] args) throws IOException, LifecycleException {
        System.out.println("Starting Tomcat...");
        new TomcatEmbeddedRunner().startServer();
    }
}
