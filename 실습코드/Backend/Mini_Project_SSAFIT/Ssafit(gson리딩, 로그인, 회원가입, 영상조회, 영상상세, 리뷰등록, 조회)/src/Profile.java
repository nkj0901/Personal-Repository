import java.io.Serializable;

public class Profile implements Serializable {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String pw;
	private String name;
	private String emial;

	public Profile(String id, String pw, String name, String emial) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.emial = emial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	@Override
	public String toString() {
		return " [id=" + id + ", pw=" + pw + ", name=" + name + ", emial=" + emial + "]";
	}

}
