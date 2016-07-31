package ua.khpi.soklakov.Practice8;

import ua.khpi.soklakov.Practice8.entity.User;

/**
 * Role entity.
 * 
 * @author O.Soklakov
 * 
 */

public enum Role {
	ADMIN, USER;
	
	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
	
}
