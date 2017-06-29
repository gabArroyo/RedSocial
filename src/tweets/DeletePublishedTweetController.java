package tweets;

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
@WebServlet("/DeletePublishedTweetController")
public class DeletePublishedTweetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TweetCreationModel tweets = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePublishedTweetController() {
        super();
        tweets = new TweetCreationModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanSession session = (BeanSession)request.getSession(false).getAttribute("user");
		int userID = session.getUserID();
		int tweetID = Integer.parseInt((String)request.getParameter("tweetID"));
		boolean success = tweets.deleteTweet(request, userID, tweetID);
		RequestDispatcher dispatcher = null;
		if(success)
			dispatcher = request.getRequestDispatcher("/TweetsPublishedController");
		else
			dispatcher = request.getRequestDispatcher("ViewProblemMessage.jsp");
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