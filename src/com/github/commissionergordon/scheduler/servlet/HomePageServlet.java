package com.github.commissionergordon.scheduler.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class HomePageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    File file = new File(getClass().getResource("../html/Home.html").getPath());

    //String htmlDoc = new Scanner(file).useDelimiter("\\\\Z").next();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().
                append(/*(CharSequence)*/new Scanner(file).useDelimiter("\\\\Z").next());
    }
}
