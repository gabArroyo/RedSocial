package followedAndFollowers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.BeanSession;

/**
 * Servlet implementation class LatestTweetsController
 */
@WebServlet("/FollowProfileController")
public class FollowProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FollowersAndFollowedModel followersAndFollowedModel = null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowProfileController() {
        super();
        followersAndFollowedModel = new FollowersAndFollowedModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null){
			int userID = ((BeanSession)session.getAttribute("user")).getUserID();
			int followedUserID = Integer.parseInt(request.getParameter("userID"));
			if(userID != followedUserID){			
				boolean followed = followersAndFollowedModel.isUserFollowed(request, userID, followedUserID);
				RequestDispatcher dispatcher = null;
				if(followed)
					dispatcher = request.getRequestDispatcher("ViewUnfollowProfile.jsp");
				else
					dispatcher = request.getRequestDispatcher("ViewFollowProfile.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}