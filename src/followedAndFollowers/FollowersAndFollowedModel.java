package followedAndFollowers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;
import dao.DBOperations;

public class FollowersAndFollowedModel {
	public FollowersAndFollowedModel(){}
	
	private BeanUserCard fillUser(ResultSet users) throws SQLException{
		BeanUserCard userCard = new BeanUserCard();
		userCard.setUserId(Integer.parseInt(users.getString("userID")));
		userCard.setUsername(users.getString("username"));
		userCard.setAvatar(users.getString("avatar"));
		
		if(users.getString("name").compareTo("null") == 0)
			userCard.setName("");
		else
			userCard.setName(users.getString("name"));
		
		return userCard;
	}
	
	private BeanUserList getUsers(ResultSet users) throws SQLException{
		BeanUserList userList = new BeanUserList();
		while(users.next()){
			userList.addUser(fillUser(users));
		}
		return userList;
	}
	
	public boolean getFollowersUsers(HttpServletRequest request, int userID){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet followerUsers = database.executeSQL("SELECT * FROM Users as U, Followers as F WHERE F.userID = " + userID + " and F.followerUserID = U.userID");
			
				boolean usersExist = DBOperations.getSizeResultSet(followerUsers) > 0 ? true : false;
				if (usersExist) {
					BeanUserList userList = getUsers(followerUsers);
					request.setAttribute("userList", userList.getUserList());
					success = true;
				}
				database.disconnectDB();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean getFollowedUsers(HttpServletRequest request, int userID){
		boolean success = false; 
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet followerUsers = database.executeSQL("SELECT * FROM Users as U, Follows as F WHERE F.userID = " + userID + " and F.followUserID = U.userID");
			
				boolean usersExist = DBOperations.getSizeResultSet(followerUsers) > 0 ? true : false;
				if (usersExist) {
					BeanUserList userList = getUsers(followerUsers);
					request.setAttribute("userList", userList.getUserList());
					success = true;
				}
				database.disconnectDB();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean getPeopleToFollow(HttpServletRequest request, int userID){
		boolean success = false; 
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet usersToFollow = database.executeSQL("SELECT * FROM USERS as U WHERE u.userID NOT IN (SELECT DISTINCT"
						+ " followUserID From Users as U, Follows as F WHERE F.userID = " + userID + ") ORDER BY RAND() LIMIT 5;");
				
				boolean usersExist = DBOperations.getSizeResultSet(usersToFollow) > 0 ? true : false;
				if (usersExist) {
					BeanUserList userList = getUsers(usersToFollow);
					request.setAttribute("userList", userList.getUserList());
					success = true;
				}
				database.disconnectDB();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean followUser(HttpServletRequest request, int userID, int followedUserID){
		boolean success = false; 
		DAO database = new DAO();
		if(database.connect()){
			try {
				database.updateSQL("INSERT INTO Followers(userID, followerUserID) VALUES (" + followedUserID + "," + userID + ")");
				database.updateSQL("INSERT INTO Follows(userID, followUserID) VALUES (" + userID + "," + followedUserID + ")");
				database.updateSQL("UPDATE Users SET numFollowers = numFollowers + 1 WHERE userID = " + followedUserID + "");
				database.updateSQL("UPDATE Users SET numFollows = numFollows + 1 WHERE userID = " + userID + "");
				
				database.disconnectDB();
				success = true;
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean unfollowUser(HttpServletRequest request, int userID, int followUserID){
		boolean success = false; 
		DAO database = new DAO();
		if(database.connect()){
			try {
				database.updateSQL("DELETE FROM Followers WHERE userID = " + followUserID + " and followerUserID = " + userID + "");
				database.updateSQL("DELETE FROM Follows WHERE userID = " + userID + " and followUserID = " + followUserID + "");
				database.updateSQL("UPDATE Users SET numFollowers = numFollowers - 1 WHERE userID = " + followUserID + "");
				database.updateSQL("UPDATE Users SET numFollows = numFollows -1 WHERE userID = " + userID + "");
				
				database.disconnectDB();
				success = true;
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
}