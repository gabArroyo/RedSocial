package utils;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.BeanSessionUser;

public class SessionFunctions {
	public static void createSession(HttpServletRequest request, String username) throws SQLException{
    	HttpSession session = request.getSession();
    	BeanSessionUser userSession = new BeanSessionUser();
    	userSession.setCurrentPage("ViewUserHome.jsp");
    	userSession.setUsername(username);
    	session.setAttribute("user", userSession);
	}

	public static boolean sessionDefined(HttpSession session){
		return session != null;
	}
}
