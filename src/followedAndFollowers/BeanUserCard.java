package followedAndFollowers;

import java.io.Serializable;

public class BeanUserCard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int userId;
	private int userType;
	private String username = "";
	private String avatar = "";
	private String content = "";
	private int numFavs;
	private int numLikes;
	private String retweetID = "";
	private String date;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNumFavs() {
		return numFavs;
	}
	public void setNumFavs(int numFavs) {
		this.numFavs = numFavs;
	}
	public int getNumLikes() {
		return numLikes;
	}
	public void setNumLikes(int numLikes) {
		this.numLikes = numLikes;
	}
	public String getRetweetID() {
		return retweetID;
	}
	public void setRetweetID(String retweetID) {
		this.retweetID = retweetID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
