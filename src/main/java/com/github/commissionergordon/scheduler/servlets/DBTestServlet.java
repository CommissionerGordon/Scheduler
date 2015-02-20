package com.github.commissionergordon.scheduler.servlets;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:./db/scheduler", "sa", "");
            DSLContext create = DSL.using(conn);

            // Create User table
            create.execute("CREATE TABLE IF NOT EXISTS user(user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(30));");

            Result<?> tableResult = create.select().from("user").fetch();
            if(tableResult.size() == 0) {
                create
                    .execute("INSERT INTO User VALUES(1, 'Justin');" +
                            "INSERT INTO User VALUES(2, 'Kyle');" +
                            "INSERT INTO User VALUES(3, 'Brandon');" +
                            "INSERT INTO User VALUES(4, 'Nathan');");
            }

            Result<?> result = create.select()
                    .from("USER")
                    .fetch();


            out.println("Runs the statement 'SELECT * FROM USER'");
            out.println();
            out.println(result);
            out.flush();
            out.close();
            conn.close();
        } catch (SQLException e) {
            out.println("There was a problem with the SQL Statement...");
            out.println();
            out.flush();
            out.close();
            e.printStackTrace();
        }

    }
}
