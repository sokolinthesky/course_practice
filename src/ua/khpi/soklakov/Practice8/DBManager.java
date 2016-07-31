package ua.khpi.soklakov.Practice8;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.khpi.soklakov.Practice8.entity.User;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

/**
 * Database manager.
 * 
 * @author O.Soklakov
 *
 */
public class DBManager {
	private static Connection connection;

	private static final String URL = "jdbc:mysql://localhost:3306/practice8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	/**
	 * Return connection. If connection is null, create it.
	 * 
	 * @return connection to database.
	 */
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Driver driver = new FabricMySQLDriver();
				DriverManager.registerDriver(driver);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * List with all users.
	 * 
	 * @return all users in database.
	 */
	public static List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		connection = getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.SELECT_ALL_USERS)) {
			connection.setAutoCommit(false);
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt("id"), resultSet.getString("login"),
						resultSet.getString("password"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getInt("role_id")));
			}
			connection.commit();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
		}

		return users;
	}

	/**
	 * Method makes order.
	 * 
	 * @param user
	 *            user who made order.
	 * @param menuItems
	 *            selected menu items.
	 */
	public static void makeOder(User user, int... menuItems) {
		int userId = user.getId();
		Integer oderId = null;
		connection = getConnection();
		try (PreparedStatement oderPs = connection.prepareStatement(Query.INSERT_ODER,
				PreparedStatement.RETURN_GENERATED_KEYS);
				PreparedStatement oderMenuPs = connection.prepareStatement(Query.INSERT_ORERS_MENU);) {
			connection.setAutoCommit(false);
			oderPs.setInt(1, userId);
			oderPs.setInt(2, 0);
			oderPs.executeUpdate();

			ResultSet rs = oderPs.getGeneratedKeys();
			if (rs.next()) {
				oderId = rs.getInt(1);
			}
			rs.close();

			for (int i = 0; i < menuItems.length; i++) {
				oderMenuPs.setInt(1, oderId);
				oderMenuPs.setInt(2, menuItems[i]);
				oderMenuPs.executeUpdate();
				oderMenuPs.addBatch();
			}
			connection.commit();
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// test find all users method.
		List<User> res = findAllUsers();
		for (User user : res) {
			System.out.println(user);
		}

		// test make oder method.
		User user = new User();
		user.setId(1);
		int[] items = { 1, 2, 3, 4, 5 };

		makeOder(user, items);

	}
}
