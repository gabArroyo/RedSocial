package user;

import java.io.Serializable;

public class BeanUserProfile implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userID;
	private String username = "";
	private String description = "";
	private String avatar = "";
	private String background = "";
	private String birth = "";
	private String name = "";
	private String surname = "";
	private String location = "";
	private String url = "";
	private int numTweets;
	private int numFollowers;
	private int numFollows;

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNumTweets() {
		return numTweets;
	}
	public void setNumTweets(int numTweets) {
		this.numTweets = numTweets;
	}
	public int getNumFollowers() {
		return numFollowers;
	}
	public void setNumFollowers(int numFollowers) {
		this.numFollowers = numFollowers;
	}
	public int getNumFollows() {
		return numFollows;
	}
	public void setNumFollows(int numFollows) {
		this.numFollows = numFollows;
	}
	
	
}
