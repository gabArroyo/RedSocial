package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.BeanSession;

/**
 * Servlet implementation class LatestTweetsController
 */
@WebServlet("/UpdateUserPrivateProfileController")
public class UpdateUserPrivateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPrivateProfileModel userPrivateProfile;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPrivateProfileController() {
        super();
        userPrivateProfile = new UserPrivateProfileModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanSession session = (BeanSession)request.getSession(false).getAttribute("user");
		boolean success = userPrivateProfile.updateProfile(request, session.getUserID());
		if(success)
			request.getRequestDispatcher("ViewUpdateSuccess.jsp").forward(request, response);
		else
			request.getRequestDispatcher("ViewPrivateProfile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}