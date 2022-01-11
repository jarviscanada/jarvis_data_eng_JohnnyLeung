package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterServiceIntTest {

  private TwitterService twitterService;

  @Before
  public void setup() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    System.out.println
        (consumerKey + "|" + consumerSecret + "|" + accessToken + "|" + tokenSecret);
    //set up dependency
    HttpHelper httpHelper =
        new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    //pass dependency
    twitterService = new TwitterService(new TwitterDao(httpHelper));
  }

  @Test
  public void postTweet() throws JsonProcessingException {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    System.out.println(JsonParser.toJson(postTweet, true, false));

    Tweet tweet = twitterService.postTweet(postTweet);

    assertEquals(text, tweet.getText());

    assertNotNull(tweet.getCoordinates());
    assertEquals(2, tweet.getCoordinates().getCoordinates().size());
    assertEquals(lon, tweet.getCoordinates().getCoordinates().get(0));
    assertEquals(lat, tweet.getCoordinates().getCoordinates().get(1));

    assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
  }

  @Test
  public void showTweet() throws JsonProcessingException {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    System.out.println(JsonParser.toJson(postTweet, true, false));

    Tweet tweet = twitterService.postTweet(postTweet);
    tweet = twitterService.showTweet(tweet.getId_str(), new String[]{});

    assertEquals(text, tweet.getText());

    assertNotNull(tweet.getCoordinates());
    assertEquals(2, tweet.getCoordinates().getCoordinates().size());
    assertEquals(lon, tweet.getCoordinates().getCoordinates().get(0));
    assertEquals(lat, tweet.getCoordinates().getCoordinates().get(1));

    assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
  }

  @Test
  public void deleteTweets() throws JsonProcessingException {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    Tweet postTweet = TweetUtil.buildTweet(text, lon, lat);
    System.out.println(JsonParser.toJson(postTweet, true, false));

    Tweet tweet = twitterService.postTweet(postTweet);
    List<Tweet> tweets = twitterService.deleteTweets(new String[]{tweet.getId_str()});

    assertEquals(text, tweets.get(0).getText());

    assertNotNull(tweets.get(0).getCoordinates());
    assertEquals(2, tweets.get(0).getCoordinates().getCoordinates().size());
    assertEquals(lon, tweets.get(0).getCoordinates().getCoordinates().get(0));
    assertEquals(lat, tweets.get(0).getCoordinates().getCoordinates().get(1));

    assertTrue(hashTag.contains(tweets.get(0).getEntities().getHashtags().get(0).getText()));
  }
}
