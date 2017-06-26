package user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;
import dao.DBOperations;

public class UserPublicProfileModel {
	public UserPublicProfileModel(){}
	
	private BeanUserProfile getUserInformation(ResultSet userInfo) throws SQLException{
		BeanUserProfile user = new BeanUserProfile();
		userInfo.next();
		user.setUserID(Integer.parseInt(userInfo.getString("userID")));
		user.setUsername(userInfo.getString("username"));
		user.setDescription(userInfo.getString("description"));
		user.setAvatar(userInfo.getString("avatar"));
		user.setBackground(userInfo.getString("background"));
		user.setBirth(userInfo.getString("birth"));
		user.setName(userInfo.getString("name"));
		user.setSurname(userInfo.getString("surname"));
		user.setLocation(userInfo.getString("location"));
		user.setUrl(userInfo.getString("url"));
		user.setNumTweets(Integer.parseInt(userInfo.getString("numTweets")));
		user.setNumFollowers(Integer.parseInt(userInfo.getString("numFollowers")));
		user.setNumFollows(Integer.parseInt(userInfo.getString("numFollows")));
		return user;
	}
	
	public boolean loadProfile(int userID, HttpServletRequest request){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet userInfo = database.executeSQL("SELECT * FROM Users as U WHERE U.userID = " + userID + "");
				request.setAttribute("user", getUserInformation(userInfo));
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
