package utils;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFunctions {
	
	public static int createSession(HttpServletRequest request, int userID, int userType, String username) throws SQLException{
		int success = 0;
		if(userType == 2){
			createAdminSession(request, userID, username);
			success = 2;
		}
		else{
			createUserSession(request, userID, username);
			success = 1;
		}
		return success;
	}
	
	public static void createUserSession(HttpServletRequest request, int userID, String username) throws SQLException{
    	BeanSession sessionInfo = new BeanSession(userID, username, "ViewUserHome.jsp");
    	
    	/* Little hack to merge two commits */
    	request.getSession().setAttribute("user", sessionInfo);
	}
	
	public static void createAdminSession(HttpServletRequest request, int userID, String username) throws SQLException{
    	BeanSession sessionInfo = new BeanSession(userID, username, "ViewUserHome.jsp");

    	/* Little hack to merge two commits */
    	request.getSession().setAttribute("user", sessionInfo);
	}


	public static boolean sessionDefined(HttpSession session){
		if(session == null || session.getAttribute("user") == null)
			return false;
		return true;
	}
}
