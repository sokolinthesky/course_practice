package ua.khpi.soklakov.Practice10.db.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.*;
import javax.sql.DataSource;

public class ConnectionStorage {

	private static Connection con;

	public static Connection getConnection() {

		try {

			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/db");
			con = ds.getConnection();

		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
}
