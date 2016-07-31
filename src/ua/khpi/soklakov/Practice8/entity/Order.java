package ua.khpi.soklakov.Practice8.entity;

/**
 * Order entity.
 * 
 * @author O.Soklakov
 * 
 */
public class Order extends Entity {

	private static final long serialVersionUID = 5692708766041889396L;

	private Long userId;
	private int statusId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", statusId="
				+ statusId + ", getId()=" + getId() + "]";
	}

}
