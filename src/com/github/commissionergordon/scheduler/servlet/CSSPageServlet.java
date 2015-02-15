package com.github.commissionergordon.scheduler.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CSSPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    File file = new File(getClass().getResource("../html/default-template.css").getPath());

    //String htmlDoc = new Scanner(file).useDelimiter("\\\\Z").next();

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().
                append(/*(CharSequence)*/new Scanner(file).useDelimiter("\\\\Z").next());
    }
}
