package utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class BeanSession implements Serializable  {

	private static final long serialVersionUID = 1L;
	private int userID;
	private String username = "";
	private String userType = "";
	
	public BeanSession(int userID, String username, String userType){
		this.userID = userID;
		this.username = username;
		this.userType = userType;
	}
	
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


}