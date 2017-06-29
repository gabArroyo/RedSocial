package likeTweet;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import dao.DAO;
import dao.DBOperations;

public class LikeTweetsModel {
	public LikeTweetsModel(){}
	
	public boolean likeTweet(HttpServletRequest request, int userID, int tweetID){
		boolean success = false; 
		DAO database = new DAO();
		if(database.connect()){
			try {
				ResultSet userLike = database.executeSQL("Select * From TweetLiked Where tweetID = " + tweetID + " and userID = " + userID + "");
				if(DBOperations.getSizeResultSet(userLike) == 0){
					database.updateSQL("UPDATE Tweets SET numLikes = numLikes + 1 WHERE tweetID = " + tweetID + "");
					database.updateSQL("Insert Into TweetLiked(tweetID, userID) VALUES(" + tweetID + ", " + userID + ")");
				}
				database.disconnectDB();
				success = true;
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return success;
	}
}