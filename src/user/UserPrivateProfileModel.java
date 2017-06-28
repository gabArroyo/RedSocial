package user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;

public class UserPrivateProfileModel {
	public UserPrivateProfileModel(){}
	
	private BeanUserProfile getUserInformation(ResultSet userInfo) throws SQLException{
		BeanUserProfile user = new BeanUserProfile();
		String content;
		userInfo.next();
		user.setUserID(Integer.parseInt(userInfo.getString("userID")));
		user.setUsername(userInfo.getString("username"));
		
		content = userInfo.getString("description");
		user.setDescription((content.compareTo("") == 0) ? "The user doesn't has a description yet." : content);
		
		user.setAvatar(userInfo.getString("avatar"));
		user.setBackground(userInfo.getString("background"));
		user.setBirth(userInfo.getString("birth"));
		
		content = userInfo.getString("name");
		if(content.compareTo("null") == 0){
			user.setName("The user remains misterious! We don't know his/her name.");
			user.setSurname("");
		}
		else{
			user.setName(content);
			user.setSurname(userInfo.getString("surname"));
		}
		
		content = userInfo.getString("location");
		user.setLocation((content.compareTo("") == 0) ? "In an unknown place." : "Lives in " + content);
		user.setUrl(userInfo.getString("url"));
		user.setNumTweets(Integer.parseInt(userInfo.getString("numTweets")));
		user.setNumFollowers(Integer.parseInt(userInfo.getString("numFollowers")));
		user.setNumFollows(Integer.parseInt(userInfo.getString("numFollows")));
		return user;
	}
	
	public boolean loadProfile(HttpServletRequest request, int userID){
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
