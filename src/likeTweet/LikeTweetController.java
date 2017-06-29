package likeTweet;

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
@WebServlet("/LikeTweetController")
public class LikeTweetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LikeTweetsModel likeTweetsModel = null;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeTweetController() {
        super();
        likeTweetsModel = new LikeTweetsModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int userID = ((BeanSession)session.getAttribute("user")).getUserID();
		int tweetID = Integer.parseInt(request.getParameter("tweetID"));
		likeTweetsModel.likeTweet(request, userID, tweetID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}