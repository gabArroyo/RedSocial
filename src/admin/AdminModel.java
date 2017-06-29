package admin;


import dao.DAO;
import dao.DBOperations;
import listTweets.BeanTweet;
import listTweets.BeanTweetsList;
import org.apache.commons.beanutils.BeanUtils;
import register.BeanRegister;
import user.BeanUserPrivateProfile;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {

  public AdminModel() {
  }

  private BeanUserPrivateProfile fillUser(ResultSet users) throws SQLException {
    BeanUserPrivateProfile userProfile = new BeanUserPrivateProfile();
    userProfile.setUserID(Integer.parseInt(users.getString("userID")));
    userProfile.setUsername(users.getString("username"));
    userProfile.setEmail(users.getString("email"));
    userProfile.setName(users.getString("name"));
    userProfile.setSurname(users.getString("surname"));
    userProfile.setGender(users.getString("gender"));
    userProfile.setUserType(users.getString("userType"));

    return userProfile;
  }

  private BeanTweet fillTweet(ResultSet tweetInfo) throws SQLException {
    BeanTweet tweet = new BeanTweet();
    tweet.setTweetId(Integer.parseInt(tweetInfo.getString("tweetID")));
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

  private BeanUserList getUsers(ResultSet users) throws SQLException {
    BeanUserList userList = new BeanUserList();
    while (users.next()) {
      userList.addUser(fillUser(users));
    }
    return userList;
  }

  public boolean getUsers(HttpServletRequest request) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        ResultSet allUsers = database.executeSQL("SELECT * FROM Users WHERE userType != 2");
        boolean usersExist = DBOperations.getSizeResultSet(allUsers) > 0 ? true : false;
        if (usersExist) {
          BeanUserList userList = getUsers(allUsers);
          request.setAttribute("userList", userList.getUserList());
          success = true;
        }
        database.disconnectDB();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  private BeanUserPrivateProfile getUser(ResultSet users) throws SQLException {
    BeanUserPrivateProfile user = new BeanUserPrivateProfile();
    while (users.next()) {
      user = fillUser(users);
    }
    return user;
  }

  private BeanTweetsList getTweets(ResultSet tweets) throws SQLException {
    BeanTweetsList tweetList = new BeanTweetsList();
    while (tweets.next()) {
      tweetList.addTweet(fillTweet(tweets));
    }
    return tweetList;
  }

  public boolean getLastTweets(HttpServletRequest request) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        ResultSet lastTweets = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userID = T.userID ORDER BY tweetID DESC LIMIT 100");
        boolean tweetsExist = DBOperations.getSizeResultSet(lastTweets) > 0 ? true : false;
        if (tweetsExist) {
          BeanTweetsList tweetList = getTweets(lastTweets);
          request.setAttribute("tweetList", tweetList.getTweetList());
          success = true;
        }
        database.disconnectDB();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  public boolean getUser(HttpServletRequest request, int userId) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        ResultSet userDB = database.executeSQL("SELECT * FROM Users WHERE userID = " + userId);
        boolean usersExist = DBOperations.getSizeResultSet(userDB) > 0 ? true : false;
        if (usersExist) {
          BeanUserPrivateProfile user = getUser(userDB);
          request.setAttribute("userEdit", user);
          success = true;
        }
        database.disconnectDB();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  private BeanTweet getTweet(ResultSet tweetDB) throws SQLException {
    BeanTweet tweet = new BeanTweet();
    while (tweetDB.next()) {
      tweet = fillTweet(tweetDB);
    }
    return tweet;
  }


  public boolean getTweet(HttpServletRequest request, int tweetId) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        ResultSet tweetDB = database.executeSQL("SELECT * FROM Tweets as T, Users as U WHERE U.userID = T.userID and tweetID = " + tweetId);
        boolean tweetExist = DBOperations.getSizeResultSet(tweetDB) > 0 ? true : false;
        if (tweetExist) {
          BeanTweet tweet = getTweet(tweetDB);
          request.setAttribute("tweetEdit", tweet);
          success = true;
        }
        database.disconnectDB();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  public boolean updateUser(HttpServletRequest request) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        BeanRegister user = new BeanRegister();
        BeanUtils.populate(user, request.getParameterMap());
        int ut = 0;
        if (request.getParameter("userType") != null) {
          ut = Integer.parseInt(request.getParameter("userType"));
          if (ut != 1) {
            ut = 0;
          }
        }

        int numRow = database.updateSQL("UPDATE USERS SET username='" + user.getUsername() + "', email='" + user.getEmail() + "', name='" + user.getName() + "', surname='" + user.getSurname() + "', gender='" + user.getGender() + "', userType=" + ut + " WHERE userID = " + request.getParameter("userID") + "");
        database.disconnectDB();
        success = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  public boolean updateTweet(HttpServletRequest request) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        BeanTweet tweet = new BeanTweet();
        BeanUtils.populate(tweet, request.getParameterMap());
        int rowNum = database.updateSQL("UPDATE Tweets SET content='" + tweet.getContent() + "' WHERE tweetID=" + request.getParameter("tweetID") + "");
        database.disconnectDB();
        success = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  public boolean deleteUser(int userId) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        int numDeleteRow = database.updateSQL("DELETE FROM Users WHERE userID = " + userId);
        if (numDeleteRow > 0) {
          success = true;
        }
        database.disconnectDB();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  public boolean deleteTweet(int tweetId) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        int numDeleteRow = database.updateSQL("DELETE FROM Tweets WHERE tweetID = " + tweetId);
        if (numDeleteRow > 0) {
          success = true;
        }
        database.disconnectDB();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return success;
  }

  public boolean getStats(HttpServletRequest request) {
    boolean success = false;
    DAO database = new DAO();
    if (database.connect()) {
      try {
        int numUsers = DBOperations.getSizeResultSet(database.executeSQL("SELECT * FROM Users WHERE userType != 2"));
        int numTweets = DBOperations.getSizeResultSet(database.executeSQL("SELECT * FROM Tweets"));
        int numFollowers = DBOperations.getSizeResultSet(database.executeSQL("SELECT * FROM Followers"));
        int numFollows = DBOperations.getSizeResultSet(database.executeSQL("SELECT * FROM Follows"));
        BeanStat stat = new BeanStat(numUsers, numTweets, numFollowers, numFollows);
        request.setAttribute("stats", stat);
        success = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return success;
  }
}
