CREATE DATABASE movieT;

USE movieT;

/* Usuarios */
CREATE TABLE Users (
  userID INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  name VARCHAR(255) DEFAULT "",
  surname VARCHAR(255) DEFAULT "",
  gender VARCHAR(255) DEFAULT "",
  birth DATE,
  avatar VARCHAR(400) DEFAULT "https://popcorntime.sh/images/logo-valentines.png",
  background VARCHAR(400) DEFAULT "http://68.media.tumblr.com/tumblr_kvf85kjKrQ1qzhiqwo1_1280.png",
  description VARCHAR(255) DEFAULT "",
  location VARCHAR(255) DEFAULT "",
  url VARCHAR(255) DEFAULT "",
  numFollowers INTEGER(10) DEFAULT 0,
  numFollows INTEGER(10) DEFAULT 0,
  numTweets INTEGER(10) DEFAULT 0,
  userType INTEGER(2) DEFAULT 0,
  register datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (userID)
);

/* Followers */
CREATE TABLE Followers (
  userID INTEGER,
  followerUserID INTEGER,
  PRIMARY KEY (userID, followerUserID)
);

/* Follows */
CREATE TABLE Follows (
  userID INTEGER,
  followUserID INTEGER,
  PRIMARY KEY (userID, followUserID)follows
);

/* Admins */
CREATE TABLE Admin (
  userID INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  name VARCHAR(255) DEFAULT "",
  surname VARCHAR(255) DEFAULT "",
  PRIMARY KEY (userID)
);

/* Película */
CREATE TABLE Films (
  filmID INTEGER NOT NULL AUTO_INCREMENT,
  filmName VARCHAR(255),
  PRIMARY KEY (filmID)
);

/* Actores por película */
CREATE TABLE FilmActors(
  filmID INTEGER,
  userID INTEGER,
  PRIMARY KEY (filmID, userID)
);

/* Tweets */
CREATE TABLE Tweets (
  tweetID INTEGER NOT NULL AUTO_INCREMENT,
  userID INTEGER,
  content VARCHAR(400),
  numFavs INTEGER,
  numLikes INTEGER,
  retweetID INTEGER,
  replyID INTEGER,
  dateTweet datetime NOT NULL DEFAULT NOW(),
  PRIMARY KEY (tweetID)
);

CREATE TABLE TweetReplies (
  tweetID INTEGER,
  tweetReplyID INTEGER,
  PRIMARY KEY (tweetID, tweetReplyID)
);

CREATE TABLE TweetReferedUsers (
  userID INTEGER,
  tweetID INTEGER,
  PRIMARY KEY (tweetID, userID)
);

INSERT INTO Users(username, password, email, name, surname, gender,
birth, avatar, background, description, numFollowers, numFollows, numTweets,
userType)
VALUES ('tasha', 'tasha123', 'Leonard.watkins60@example.com',
'Leonard', 'Watkins', 'Male', '1990-5-17',
'https://randomuser.me/api/portraits/men/29.jpg',
'http://www.guoguiyan.com/data/out/160/68823904-random-wallpapers.png',
"Hi, my name is Leonard and I do things.", 3, 1, 2, 0);


INSERT INTO Users(username, password, email, name, surname, gender,
birth, avatar, background, description, numFollowers, numFollows, numTweets,
userType)
VALUES ('pulled', 'reallyPulled', 'adrian.holland55@example.com',
'Adrian', 'Holland', 'Male', '1977-4-12',
'https://randomuser.me/api/portraits/men/97.jpg',
'http://www.guoguiyan.com/data/out/160/68624858-random-wallpapers.jpg',
"HIIIIIIIIIIIIIIIIIIIIIII.", 1, 1, 2, 0);

INSERT INTO Users(username, password, email, name, surname, gender,
birth, avatar, background, description, numFollowers, numFollows, numTweets,
userType)
VALUES ('ripple', 'ripple123', 'wesley.nichols90@example.com',
'Wesley', 'Nichols', 'Male', '1976-6-7',
'https://randomuser.me/api/portraits/men/77.jpg',
'http://k30.kn3.net/3/2/5/B/0/D/7FE.jpg',
"Bu.", 0, 0, 1, 0);


INSERT INTO Users(username, password, email, name, surname, gender,
birth, avatar, background, description, numFollowers, numFollows, numTweets,
userType)
VALUES ('grant', 'realGrant', 'patrick.burke79@example.com',
'Patrick', 'Burke', 'Male', '1977-7-6',
'https://randomuser.me/api/portraits/men/87.jpg',
'http://www.guoguiyan.com/data/out/160/69308578-random-wallpapers.jpg',
"Hellow.", 2, 1, 3, 0);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (4, 'Love @VinDiesel!', 1, 1, null);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (4, 'OMG!', 0, 0, null);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (4, '', 0, 0, 18);

INSERT INTO TweetReplies(tweetID, tweetReplyID)
VALUES (16,20);

INSERT INTO TweetReferedUsers(userID, tweetID)
VALUES (6,16);


INSERT INTO Users(username, password, email, name, surname, gender,
birth, avatar, background, description, numFollowers, numFollows, numTweets,
userType)
VALUES ('play', 'play123', 'phyllis.graves17@example.com',
'Phyllis', 'Graves', 'Female', '1977-11-1',
'https://randomuser.me/api/portraits/women/48.jpg',
'http://www.telegraph.co.uk/content/dam/Travel/Destinations/Europe/Russia/Moscow/moscow-go-red-square-xlarge.jpg',
"Hi, I'm Phyllis.", 0, 1, 1, 0);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (5, 'Hello everyone!', 100, 100, null);

INSERT INTO Users(username, password, email, name, surname, gender,
birth, avatar, background, description, numFollowers, numFollows, numTweets,
userType)
VALUES ('VinDiesel', 'vinnie123', 'realVinnie@example.com',
'Mark', 'Sinclair Vincent', 'Male', '1967-12-12',
'http://cdn2.estamosrodando.com/biografias/7/14/vin-diesel-751865.jpg',
'https://images6.alphacoders.com/391/391912.jpg',
"I'm Vin Diesel..", 0, 4, 1, 1);

INSERT INTO Tweets(userID, content, numFavs, numLikes, replyID)
VALUES (6, 'Thanks!', 1000, 1000, 16);

INSERT INTO Followers(userID, followerUserID)
VALUES (1,2), (1,3), (1, 4),
(2,4),
(4,2),
(6,1),(6,2),(6,4),(6,5);

INSERT INTO Follows(userID, followUserID)
VALUES(1,6),
(2,1),(2,4),(2,6),
(3,1),
(4,1), (4,2), (4,6),
(5,6);

INSERT INTO Admin(username, password, email, name, surname)
VALUES ('admin', 'admin123', 'admin@filmit.com',
'Josh', 'James');

INSERT INTO Films(filmName)
VALUES ('Fast and Furious');

INSERT INTO FilmActors(filmID, userID)
VALUES (1, 6);


INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (1, 'Hello World!', 1, 2, null);

INSERT INTO TweetReplies(tweetID, tweetReplyID)
VALUES (1,3);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (1, 'So happy to have watched @VinDiesel latest film!', 2, 2, null);

INSERT INTO TweetReferedUsers(userID, tweetID)
VALUES (6,2);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (2, 'Hi and welcome!', 1, 1, null);

INSERT INTO Tweets(userID, content, numFavs, numLikes, retweetID)
VALUES (3, "I'm bored!", 1, 1, null);