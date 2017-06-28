package listTweets;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;
import dao.DBOperations;

public class ListTweetsModel {
	public ListTweetsModel(){}
	
	private BeanTweet fillTweet(ResultSet tweetInfo) throws SQLException{
		BeanTweet tweet = new BeanTweet();
		tweet.setUserId(Integer.parseInt(tweetInfo.getString("userID")));
		tweet.setUsername(tweetInfo.getString("username"));
		tweet.setUserType(Integer.parseInt(tweetInfo.getString("userType")));
		tweet.setAvatar(tweetInfo.getString("avatar"));
		tweet.setContent(tweetInfo.getString("content"));
		tweet.setNumFavs(Integer.parseInt(tweetInfo.getString("numFavs")));
		tweet.setNumLikes(Integer.parseInt(tweetInfo.getString("numLikes")));
		tweet.setRetweetID(tweetInfo.getString("retweetID"));
		tweet.setDate(tweetInfo.getString("dateTweet"));
		return tweet;
	}
	
	private BeanTweetsList getTweets(ResultSet tweets) throws SQLException{
		BeanTweetsList tweetList = new BeanTweetsList();
		while(tweets.next()){
			tweetList.addTweet(fillTweet(tweets));
		}
		return tweetList;
	}
	
	public boolean getLatestTweets(HttpServletRequest request){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userID = T.userID ORDER BY tweetID DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
	
	public boolean getPopularTweets(HttpServletRequest request){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userID = T.userID ORDER BY numLikes DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
	
	public boolean getActorTweets(HttpServletRequest request){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userType = 1 and U.userID = T.userID ORDER BY T.tweetID DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
	
	public boolean getFilmTweets(HttpServletRequest request){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets ORDER BY tweetID DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
	
	public boolean getUserLatestTweets(HttpServletRequest request, int userID){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userID = " + userID + " and U.userID = T.userID ORDER BY tweetID DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
	
	public boolean getUserMostPopularTweets(HttpServletRequest request, int userID){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userID = " + userID + " and U.userID = T.userID ORDER BY numLikes DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
	
	public boolean getTweetsPersonalTimeline(HttpServletRequest request, int userID){
		boolean success = false;
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet latestTweets = database.executeSQL("SELECT * FROM Tweets as T, Follows as F, Users as U WHERE F.userID = " + userID + " and F.followUserID = T.userID and T.userID = U.userID ORDER BY T.tweetID DESC LIMIT 30");
			
				boolean tweetsExist = DBOperations.getSizeResultSet(latestTweets) > 0 ? true : false;
				if (tweetsExist) {
					BeanTweetsList tweetlist = getTweets(latestTweets);
					request.setAttribute("tweets", tweetlist.getTweetList());
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
}
