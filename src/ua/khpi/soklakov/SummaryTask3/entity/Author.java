package ua.khpi.soklakov.SummaryTask3.entity;

/**
 * Author bean.
 * 
 * @author O.Soklakov.
 *
 */
public class Author {
	private String name;
	private boolean famous;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFamous() {
		return famous;
	}

	public void setFamous(boolean famous) {
		this.famous = famous;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", famous=" + famous + "]";
	}

}
