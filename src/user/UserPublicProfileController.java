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
@WebServlet("/UserPublicProfileController")
public class UserPublicProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserPublicProfileModel userPublicProfile;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPublicProfileController() {
        super();
        userPublicProfile = new UserPublicProfileModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanSession session = (BeanSession)request.getSession(false).getAttribute("user");
		int userID = session.getUserID();
		if(request.getParameter("userID") != null)
			userID = Integer.parseInt(request.getParameter("userID"));
			
		userPublicProfile.loadProfile(userID, request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewUserPublicProfile.jsp");
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