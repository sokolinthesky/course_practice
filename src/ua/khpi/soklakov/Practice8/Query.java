package ua.khpi.soklakov.Practice8;

public class Query {
	
	public static final String SELECT_ALL_USERS = "SELECT * FROM users";
	public static final String INSERT_ODER = "insert into orders (user_id, status_id) values (?, ?);";
	public static final String INSERT_ORERS_MENU = "insert into orders_menu (order_id, menu_id) values (?, ?);";

}
