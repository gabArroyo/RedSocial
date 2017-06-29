package followedAndFollowers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LatestTweetsController
 */
@WebServlet("/ListFollowersController")
public class ListFollowersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FollowersAndFollowedModel followersAndFollowedModel = null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFollowersController() {
        super();
        followersAndFollowedModel = new FollowersAndFollowedModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		boolean success = followersAndFollowedModel.getFollowersUsers(request, userID);
		RequestDispatcher dispatcher = null;
		if(success)
			dispatcher = request.getRequestDispatcher("ViewFollowersUsers.jsp");
		else
			dispatcher =request.getRequestDispatcher("ViewFollowersOrFollowProblem.jsp");
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