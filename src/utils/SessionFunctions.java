package utils;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFunctions {
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
