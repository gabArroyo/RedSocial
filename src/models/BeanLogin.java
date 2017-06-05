package models;

import java.io.Serializable;

public class BeanLogin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userOrEmail = "";
	private String password = "";
	private int[] error = {0, 0};
	
	public String getUserOrEmail(){
		return userOrEmail;
	}
	
	public void setUserOrEmail(String user){
		this.userOrEmail = user;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setErrorUser() {
		this.error[0] = 1;
	}
	
	public void setErrorPassword() {
		this.error[1] = 1;
	}
	
	public int[] getError() {
		return error;
	}
	
	public boolean isComplete() {
	    return(hasValue(getUserOrEmail()));
	}
	
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
	
}
