package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.BeanSession;

/**
 * Servlet implementation class LatestTweetsController
 */
@WebServlet("/UserPrivateProfileController")
public class UserPrivateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPrivateProfileModel userPrivateProfile;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPrivateProfileController() {
        super();
        userPrivateProfile = new UserPrivateProfileModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanSession session = (BeanSession)request.getSession(false).getAttribute("user");
		userPrivateProfile.loadProfile(request, session.getUserID());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPrivateProfile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}