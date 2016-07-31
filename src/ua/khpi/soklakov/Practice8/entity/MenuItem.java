package ua.khpi.soklakov.Practice8.entity;

/**
 * Menu item entity.
 * 
 * @author O.Soklakov
 * 
 */
public class MenuItem extends Entity {

	private static final long serialVersionUID = 4716395168539434663L;

	private String name;
	private Integer price;
	private Long categoryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", price=" + price + ", categoryId="
				+ categoryId + ", getId()=" + getId() + "]";
	}

}