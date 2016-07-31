package ua.khpi.soklakov.Practice10.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.khpi.soklakov.Practice10.db.util.ConnectionStorage;
import ua.khpi.soklakov.Practice10.entity.User;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	@Override
	public User findUserByLogin(String login) {
		User user = null;
		connection = ConnectionStorage.getConnection();
		try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM users where login = (?)")) {
			ps.setString(1, login);
			ps.execute();

			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("password"),
						rs.getInt("role_id"));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection();
		}

		return user;
	}

	@Override
	public void editUser(User user) {
		connection = ConnectionStorage.getConnection();
		try (Statement statement = connection.createStatement()) {
			statement.execute("UPDATE users SET name = '" + user.getName() + "', login = '" + user.getLogin()
					+ "', password = '" + user.getPassword() + "', role_id = " + user.getRoleId() + " " + "WHERE id = "
					+ user.getId() + ";");
		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			closeConnection();
		}

	}

	/**
	 * Method closes connection.
	 */
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
