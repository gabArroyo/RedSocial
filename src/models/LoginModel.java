package models;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import utils.CheckValuesFunctions;
import utils.DBOperations;
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
	
	public boolean doLogin(HttpServletRequest request){
		DAO database = new DAO();
		BeanLogin userInfo = new BeanLogin();
		try {
			BeanUtils.populate(userInfo, request.getParameterMap());
			String userIdentifier = userInfo.getUserOrEmail();
			ResultSet userFound = null;
			
			if(CheckValuesFunctions.checkIfEmail(userIdentifier))
				userFound = database.executeSQL("SELECT * FROM USER WHERE email LIKE '" + userIdentifier + "'");
			else
				userFound = database.executeSQL("SELECT * FROM USER WHERE username LIKE '" + userIdentifier + "'");
			
			boolean userExists = DBOperations.getSizeResultSet(userFound) > 0 ? true : false;
			
			if (userExists) {
				if(samePassword(userFound, userInfo)){
					userFound.next();
					SessionFunctions.createSession(request, userFound.getString("username"));
					return true;
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
		}
		catch (IllegalAccessException | SQLException | InvocationTargetException e){
			e.printStackTrace();
		}
		return false;
	}

}
