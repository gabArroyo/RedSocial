package logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutModel {
	
	public LogoutModel(){}
	
	public boolean doLogout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if (session!=null){
			session.invalidate();
			return true;
		}
		return false;
	}

}
