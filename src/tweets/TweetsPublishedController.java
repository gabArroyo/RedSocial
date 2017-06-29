package tweets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listTweets.ListTweetsModel;
import utils.BeanSession;

/**
 * Servlet implementation class LatestTweetsController
 */
@WebServlet("/TweetsPublishedController")
public class TweetsPublishedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListTweetsModel tweets = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetsPublishedController() {
        super();
        tweets = new ListTweetsModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeanSession session = (BeanSession)request.getSession(false).getAttribute("user");
		boolean success = tweets.getUserLatestTweets(request, session.getUserID());
		RequestDispatcher dispatcher = null;
		if(success)
			dispatcher = request.getRequestDispatcher("ViewEditTweets.jsp");
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