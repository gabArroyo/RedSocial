package tweets;

import java.io.Serializable;

public class BeanPublishTweet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int tweetID;
	private String content = "";

	public int getTweetID() {
		return tweetID;
	}

	public void setTweetID(int tweetID) {
		this.tweetID = tweetID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
