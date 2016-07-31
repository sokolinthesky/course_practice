package ua.khpi.soklakov.Practice10.entity;

/**
 * User bean.
 * 
 * @author O.Soklakov
 *
 */
public class User {
	private int id;
	private String name;
	private String login;
	private String password;
	private int roleId;

	public User(int id, String name, String login, String password, int roleId) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.roleId = roleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
