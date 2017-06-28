package followedAndFollowers;

import java.io.Serializable;
import java.util.ArrayList;

public class BeanUserList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<BeanUserCard> userList = null;
	
	public BeanUserList(){
		userList = new ArrayList<BeanUserCard>();
	}
	
	public void addUser(BeanUserCard user){
		userList.add(user);
	}

	public ArrayList<BeanUserCard> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<BeanUserCard> userList) {
		this.userList = userList;
	}
}
