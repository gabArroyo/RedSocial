package user;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import dao.DAO;
import dao.DBOperations;


public class UserPrivateProfileModel {
	public UserPrivateProfileModel(){}
	
	private BeanUserPrivateProfile getUserInformation(ResultSet userInfo) throws SQLException{
		BeanUserPrivateProfile user = new BeanUserPrivateProfile();
		userInfo.next();
		user.setUserID(Integer.parseInt(userInfo.getString("userID")));
		user.setUsername(userInfo.getString("username"));
		user.setEmail(userInfo.getString("email"));
		user.setPassword(userInfo.getString("password"));
		String content = userInfo.getString("description");
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
	
	private boolean usernameExists(DAO database, BeanUserPrivateProfile user) throws SQLException{
		ResultSet usersWithSameNameFound = database.executeSQL("SELECT * FROM USERS as U, ADMIN as A WHERE U.username LIKE '"
		+ user.getUsername() + "' OR A.username LIKE '" + user.getUsername() + "'");
		
		int numUsersFound = DBOperations.getSizeResultSet(usersWithSameNameFound);
		if(numUsersFound > 0){
			user.setErrorUser();
			return true;
		}
		return false;
		
	}
	
	private boolean emailExists(DAO database, BeanUserPrivateProfile user) throws SQLException{
		ResultSet equalEmailsFound = database.executeSQL("SELECT * FROM USERS as U, ADMIN as A WHERE U.email LIKE '" 
				+ user.getEmail() + "' OR A.email LIKE '" + user.getEmail() + "'");
		int numEmailsFound = DBOperations.getSizeResultSet(equalEmailsFound);
		if(numEmailsFound > 0){
			user.setErrorUser();
			return true;
		}
		return false;
	}
	
	public boolean updateProfile(HttpServletRequest request, int userID){
		boolean success = false;
		DAO database = new DAO();
			if(database.connect()){
				try {
					BeanUserPrivateProfile user = new BeanUserPrivateProfile();
					BeanUtils.populate(user, request.getParameterMap());
					boolean dataNotAvailable = false;
					
					dataNotAvailable = usernameExists(database, user);
					dataNotAvailable = emailExists(database, user);
					
					if(dataNotAvailable == false){
						if(user.getUsername() != "")
							database.updateSQL("UPDATE USERS SET username = '" + user.getUsername() + "' WHERE userID = " + userID);
						if(user.getPassword() != "")
							database.updateSQL("UPDATE USERS SET password = '" + user.getPassword() + "' WHERE userID = " + userID);
						if(user.getEmail() != "")
							database.updateSQL("UPDATE USERS SET email = '" + user.getEmail() + "' WHERE userID = " + userID);
						if(user.getName() != "")
							database.updateSQL("UPDATE USERS SET name = '" + user.getName() + "' WHERE userID = " + userID);
						if(user.getSurname() != "")
							database.updateSQL("UPDATE USERS SET surname = '" + user.getSurname() + "' WHERE userID = " + userID);
						if(user.getGender() != "")
							database.updateSQL("UPDATE USERS SET gender = '" + user.getGender() + "' WHERE userID = " + userID);
						if(user.getBirth() != ""){
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							java.util.Date utilDate = format.parse(user.getBirth());
							java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
							database.updateSQL("UPDATE USERS SET birth = " + sqlDate + " WHERE userID = " + userID);
						}
						if(user.getAvatar() != "")
							database.updateSQL("UPDATE USERS SET avatar = '" + user.getAvatar() + "' WHERE userID = " + userID);
						if(user.getBackground() != "")
							database.updateSQL("UPDATE USERS SET background = '" + user.getBackground() + "' WHERE userID = " + userID);
						if(user.getDescription() != "")
							database.updateSQL("UPDATE USERS SET description = '" + user.getDescription() + "' WHERE userID = " + userID);
						if(user.getLocation() != "")
							database.updateSQL("UPDATE USERS SET location = '" + user.getLocation() + "' WHERE userID = " + userID);
						if(user.getUrl() != "")
							database.updateSQL("UPDATE USERS SET url = '" + user.getUrl() + "' WHERE userID = " + userID);
						success = true;
					}
					else
						request.setAttribute("user", user);
					
					database.disconnectDB();
				}
				catch (IllegalAccessException | SQLException | ParseException | InvocationTargetException e){
					e.printStackTrace();
				}
			}
			return success;
	}
}
