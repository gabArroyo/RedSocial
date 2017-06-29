package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.SessionFunctions;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/ContentMainController")
public class ContentMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentMainController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(SessionFunctions.sessionDefined(session)){
			String content = (String)request.getParameter("controller");
			if(content == null)
				content = "";
			switch(content){
				case "latestTweets":
					request.getRequestDispatcher("/ListTweetsController").forward(request, response);
					break;
				case "personalTimeline":
					request.getRequestDispatcher("/ListTweetsController").forward(request, response);
					break;
				case "publicProfile":
					request.getRequestDispatcher("/UserPublicProfileController").forward(request, response);
					break;
				case "publishTweet":
					request.getRequestDispatcher("/ShowTweetPublisherController").forward(request, response);
					break;
				case "editTweet":
					request.getRequestDispatcher("/TweetsPublishedController").forward(request, response);
					break;
				case "personalPage":
					request.getRequestDispatcher("/ShowUserPrivateProfileController").forward(request, response);
					break;
				case "personalFollowers":
					request.getRequestDispatcher("/ListPersonalFollowersController").forward(request, response);
					break;
				case "personalFollow":
					request.getRequestDispatcher("/ListPersonalFollowController").forward(request, response);
					break;
				default:
					request.getRequestDispatcher("/UserPublicProfileController").forward(request, response);
					break;
			}
		}
		else
			request.getRequestDispatcher("/HomeController").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}