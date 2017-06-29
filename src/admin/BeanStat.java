package admin;

/**
 * Created by cbr4yan on 29/6/17.
 */
public class BeanStat {
  private static final long serialVersionUID = 1L;
  private int numUsers;
  private int numTweets;
  private int numFollowers;
  private int numFollows;

  public BeanStat() {
  }

  public BeanStat(int numUsers, int numTweets, int numFollowers, int numFollows) {
    this.numUsers = numUsers;
    this.numTweets = numTweets;
    this.numFollowers = numFollowers;
    this.numFollows = numFollows;
  }

  public int getNumUsers() {
    return numUsers;
  }

  public void setNumUsers(int numUsers) {
    this.numUsers = numUsers;
  }

  public int getNumTweets() {
    return numTweets;
  }

  public void setNumTweets(int numTweets) {
    this.numTweets = numTweets;
  }

  public int getNumFollowers() {
    return numFollowers;
  }

  public void setNumFollowers(int numFollowers) {
    this.numFollowers = numFollowers;
  }

  public int getNumFollows() {
    return numFollows;
  }

  public void setNumFollows(int numFollows) {
    this.numFollows = numFollows;
  }
}
