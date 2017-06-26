package listTweets;

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
@WebServlet("/ListTweetsController")
public class ListTweetsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListTweetsModel latestTweets = null;
	private String currentCategory = "latestTweets";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTweetsController() {
        super();
        latestTweets = new ListTweetsModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = (String)request.getParameter("action");
		if(content == null)
			content = "latestTweets";
		RequestDispatcher dispatcher = null;
		boolean tweetsFound = false;
		switch(content){
			case "latestTweets":
				tweetsFound = latestTweets.getLatestTweets(request);
				currentCategory = "latestTweets";
				break;
			case "mostPopularTweets":
				tweetsFound = latestTweets.getPopularTweets(request);
				currentCategory = "mostPopularTweets";
				break;
			case "latestTweetsActors":
				tweetsFound = latestTweets.getActorTweets(request);
				currentCategory = "latestTweetsActors";
				break;
			case "latestFilms":
				tweetsFound = latestTweets.getFilmTweets(request);
				currentCategory = "latestFilms";
				break;
			case "personalTimeline":
				tweetsFound = latestTweets.getTweetsPersonalTimeline(request, Integer.parseInt(request.getParameter("userID")));
				currentCategory = "personalTimeline";
			case "profileLatestTweets":
				tweetsFound = latestTweets.getUserLatestTweets(request, Integer.parseInt(request.getParameter("userID")));
				currentCategory = "profileLatestTweets";
			case "profileMostPopular":
				tweetsFound = latestTweets.getUserMostPopularTweets(request, Integer.parseInt(request.getParameter("userID")));
				currentCategory = "profileMostPopular";
			default:
				break;
		}
		if(tweetsFound == false)
			dispatcher = request.getRequestDispatcher("ViewErrorTweets.jsp");
		else
			dispatcher = request.getRequestDispatcher("ViewListTweets.jsp");
		request.setAttribute("category", currentCategory);
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