package com.github.commissionergordon.scheduler.servlets;

import com.github.commissionergordon.scheduler.Main;
import org.jooq.DSLContext;
import org.jooq.Record;
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

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.*;

public class DBTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
            DSLContext database = DSL.using(conn);

            // Add users to the USER table
            database.insertInto(USER, USER.USER_NAME)
                    .values("Justin")
                    .values("Kyle")
                    .values("Brandon")
                    .values("Nathan").returning().fetch();

            Result<Record> result = database.select().from(USER).fetch();
            out.println("Runs the statement 'SELECT * FROM USER'");
            out.println();
            out.println(result);
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
