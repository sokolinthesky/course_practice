package ua.khpi.soklakov.Practice9;

import java.util.ArrayList;
import java.util.List;

public class KindOfSport {

	private String name;
	private List<String> voutedName = new ArrayList<>();
	int count;

	public KindOfSport() {

	}

	public KindOfSport(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return voutedName.size();
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getVoutedName() {
		return voutedName;
	}

	public void setVoutedName(List<String> voutedName) {
		this.voutedName = voutedName;
	}

}
