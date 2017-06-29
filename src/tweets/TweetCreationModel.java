package tweets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.DAO;
import dao.DBOperations;

public class TweetCreationModel {
	
	public TweetCreationModel(){}
	
	private BeanPublishTweet fillTweet(ResultSet tweetInfo) throws SQLException{
		tweetInfo.next();
		BeanPublishTweet tweet = new BeanPublishTweet();
		tweet.setTweetID(Integer.parseInt(tweetInfo.getString("tweetID")));
		tweet.setContent(tweetInfo.getString("content"));
		return tweet;
	}
	
	public boolean getTweet(HttpServletRequest request, int tweetID){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet tweet = database.executeSQL("SELECT * FROM Tweets as T WHERE T.tweetID = " + tweetID + "");
				boolean tweetExist = DBOperations.getSizeResultSet(tweet) > 0 ? true : false;
				if (tweetExist) {
					request.setAttribute("tweet", fillTweet(tweet));
					success = true;
				}
				database.disconnectDB();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean updateTweet(HttpServletRequest request){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				BeanPublishTweet newTweet = new BeanPublishTweet();
				BeanUtils.populate(newTweet, request.getParameterMap());
				database.updateSQL("UPDATE Tweets SET content = '" + newTweet.getContent() + "' Where tweetID = " + newTweet.getTweetID());
				database.disconnectDB();
				success = true;
			}
			catch (SQLException | InvocationTargetException | IllegalAccessException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public boolean createTweet(HttpServletRequest request, int userID) throws ServletException, IOException {
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				BeanPublishTweet tweet = new BeanPublishTweet();
				BeanUtils.populate(tweet, request.getParameterMap());
				database.updateSQL("Insert Into Tweets(userID, content, numFavs, numLikes) VALUES(" + userID + ", \"" + tweet.getContent() +
						"\", " + 0 + ", " + 0 + ")");
				database.updateSQL("Update Users SET numTweets = numTweets + 1 Where userID = " + userID + "");
				success = true;
				database.disconnectDB();
			}
			catch (IllegalAccessException | SQLException | InvocationTargetException e){
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean deleteTweet(HttpServletRequest request, int userID, int tweetID) throws ServletException, IOException {
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				BeanPublishTweet tweet = new BeanPublishTweet();
				BeanUtils.populate(tweet, request.getParameterMap());
				database.updateSQL("DELETE FROM Tweets WHERE tweetID = " + tweetID + " and userID = " + userID);
				database.updateSQL("Update Users SET numTweets = numTweets - 1 Where userID = " + userID + "");
				success = true;
				database.disconnectDB();
			}
			catch (IllegalAccessException | SQLException | InvocationTargetException e){
				e.printStackTrace();
			}
		}
		return success;
	}
}