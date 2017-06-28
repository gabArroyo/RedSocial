package followedAndFollowers;

import java.io.Serializable;

public class BeanUserCard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int userId;
	private String username = "";
	private String name = "";
	private String avatar = "";

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}