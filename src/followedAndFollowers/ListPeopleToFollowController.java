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
@WebServlet("/ListPeopleToFollowController")
public class ListPeopleToFollowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FollowersAndFollowedModel followersAndFollowedModel = null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPeopleToFollowController() {
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
			boolean success = followersAndFollowedModel.getPeopleToFollow(request, userID);
			RequestDispatcher dispatcher = null;
			if(success)
				dispatcher = request.getRequestDispatcher("ViewPeopleToFollow.jsp");
			else
				dispatcher =request.getRequestDispatcher("ViewFollowersOrFollowProblem.jsp");
			dispatcher.forward(request, response);
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