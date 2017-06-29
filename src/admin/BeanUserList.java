package admin;

import user.BeanUserPrivateProfile;

import java.io.Serializable;
import java.util.ArrayList;

public class BeanUserList implements Serializable {
  private static final long serialVersionUID = 1L;

  private ArrayList<BeanUserPrivateProfile> userList;

  public BeanUserList() {
    this.userList = new ArrayList<BeanUserPrivateProfile>();
  }


  public void addUser(BeanUserPrivateProfile user) {
    this.userList.add(user);
  }

  public ArrayList<BeanUserPrivateProfile> getUserList() {
    return userList;
  }

  public void setUserList(ArrayList<BeanUserPrivateProfile> userList) {
    this.userList = userList;
  }
}
