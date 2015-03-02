package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.USER;


public class User implements SQLObject {

    private int id;
    private String name;

    private List<Activity> activities;

    public User(int id, String name) {
        this.id = id;
        this.name = name;

        activities = new ArrayList<Activity>();
    }

	@Override
	public void update() throws SQLException {
		try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
			DSLContext database = DSL.using(conn);

			database.update(USER)
				.set(USER.USER_NAME, name)
				.where(USER.USER_ID.equal(id))
				.returning().fetch();
		}
	}
}
