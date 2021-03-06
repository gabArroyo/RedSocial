package login;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import dao.DAO;
import dao.DBOperations;
import utils.CheckValuesFunctions;
import utils.SessionFunctions;

public class LoginModel {
	public LoginModel(){}
	
	private boolean samePassword(ResultSet userFound, BeanLogin userInfo) throws SQLException{
		userFound.next();
		String userPass = userFound.getString("password");
		String userInfoPass = userInfo.getPassword();
		userFound.beforeFirst();
		return userPass.compareTo(userInfoPass) == 0;
	}
	
	public int doLogin(HttpServletRequest request){
		int success = 0;
		DAO database = new DAO();
		if(database.connect()){
			BeanLogin userInfo = new BeanLogin();
			try {
				BeanUtils.populate(userInfo, request.getParameterMap());
				String userIdentifier = userInfo.getUserOrEmail();
				ResultSet userFound = null;
				
				if(CheckValuesFunctions.checkIfEmail(userIdentifier)){
					userFound = database.executeSQL("SELECT * FROM USERS WHERE email LIKE '" + userIdentifier + "'");
				}
				else{
					userFound = database.executeSQL("SELECT * FROM USERS WHERE username LIKE '" + userIdentifier + "'");
				}
				
				boolean userExists = DBOperations.getSizeResultSet(userFound) > 0 ? true : false;
				if (userExists) {
					if(samePassword(userFound, userInfo)){
						userFound.next();
						success = SessionFunctions.createSession(request, Integer.parseInt(userFound.getString("userID")), Integer.parseInt(userFound.getString("userType")), userFound.getString("username"));
					}
					else{
						userInfo.setErrorPassword();
						request.setAttribute("userLogin", userInfo);
					}
				}
				else{
					userInfo.setErrorUser();
					request.setAttribute("userLogin", userInfo);
				}
				database.disconnectDB();
			}
			catch (IllegalAccessException | SQLException | InvocationTargetException e){
				e.printStackTrace();
			}
		}
		return success;
	}
}
