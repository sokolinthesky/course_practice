package ua.khpi.soklakov.SummaryTask3.entity;

/**
 * Type bean.
 * 
 * @author O.Soklakov
 *
 */
public class Type {

	private String type;
	private boolean isSend;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isSend() {
		return isSend;
	}

	public void setSend(boolean isSend) {
		this.isSend = isSend;
	}

	@Override
	public String toString() {
		return "Type [type=" + type + ", isSend=" + isSend + "]";
	}

}
