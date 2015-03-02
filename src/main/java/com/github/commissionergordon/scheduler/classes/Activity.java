package com.github.commissionergordon.scheduler.classes;

import com.github.commissionergordon.scheduler.Main;
import com.github.commissionergordon.scheduler.interfaces.Constraint;
import com.github.commissionergordon.scheduler.interfaces.SQLObject;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.github.commissionergordon.scheduler.jooq.generated.Tables.*;

/*
    Activity Table Schema

    ACTIVITY_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    USER_ID     INTEGER NOT NULL,
    NAME        VARCHAR(30) NOT NULL,
    DURATION    TIMESTAMP NOT NULL,
    ENABLED     BOOLEAN DEFAULT TRUE NOT NULL,
    STARTTIME   TIME,
    PRIORITY    INTEGER DEFAULT 0 NOT NULL
*/

public class Activity implements SQLObject {
    public int id;
    public User user;
    public String name;
    public LocalTime duration;
    public boolean enabled;
    public LocalTime startTime;
    public int priority;

    private List<Constraint> constraints = new ArrayList<Constraint>();

    public Activity(int id, User user, String name, LocalTime duration, boolean enabled, LocalTime startTime, int priority){
        this.id = id;
        this.user = user;
        this.name = name;
        this.duration = duration;
        this.enabled = enabled;
        this.startTime = startTime;
        this.priority = priority;
    }

    public Activity(int id, User user, String name, LocalTime duration){
        this(id, user, name, duration, true, null, 1);
    }

	public int getId() {
		return id;
	}

    @Override
    public void update() throws SQLException {
		try(Connection conn = DriverManager.getConnection(Main.getDBConnectionString(), Main.getDbUser(), "")) {
			DSLContext database = DSL.using(conn);

			database.update(ACTIVITY)
				.set(ACTIVITY.NAME, name)
				.set(ACTIVITY.DURATION, Time.valueOf(duration))
				.set(ACTIVITY.ENABLED, enabled)
				.set(ACTIVITY.STARTTIME, Time.valueOf(startTime))
				.set(ACTIVITY.PRIORITY, priority)
				.where(ACTIVITY.ACTIVITY_ID.equal(id))
				.returning().fetch();
		}
    }
}
