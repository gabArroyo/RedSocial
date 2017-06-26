package listTweets;

import java.io.Serializable;
import java.util.ArrayList;

public class BeanTweetsList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<BeanTweet> tweetList = null;
	
	public BeanTweetsList(){
		tweetList = new ArrayList<BeanTweet>();
	}
	
	public void addTweet(BeanTweet tweet){
		tweetList.add(tweet);
	}

	public ArrayList<BeanTweet> getTweetList() {
		return tweetList;
	}

	public void setTweetList(ArrayList<BeanTweet> tweetList) {
		this.tweetList = tweetList;
	}
}
