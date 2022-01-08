package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerIntTest {

  private TwitterController controller;

  @Before
  public void setUp() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    System.out.println(
        consumerKey + "|" + consumerSecret + "|" + accessToken + "|" + tokenSecret);
    //set up dependency
    HttpHelper httpHelper =
        new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    //pass dependency
    this.controller = new TwitterController(new TwitterService(new TwitterDao(httpHelper)));
  }

  @Test
  public void postTweet() {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;

    Tweet tweet =
        controller.postTweet(new String[]{"post", text, String.format("%s:%s", lat, lon)});

    assertEquals(text, tweet.getText());

    assertNotNull(tweet.getCoordinates());
    assertEquals(2, tweet.getCoordinates().getCoordinates().size());
    assertEquals(lon, tweet.getCoordinates().getCoordinates().get(0));
    assertEquals(lat, tweet.getCoordinates().getCoordinates().get(1));

    assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
  }

  @Test
  public void showTweet() {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;

    Tweet tweet =
        controller.postTweet(new String[]{"post", text, String.format("%s:%s", lat, lon)});
    tweet = controller.showTweet(new String[]{"show", tweet.getId_str(), "text, coordinates"});

    assertEquals(text, tweet.getText());

    assertNotNull(tweet.getCoordinates());
    assertEquals(2, tweet.getCoordinates().getCoordinates().size());
    assertEquals(lon, tweet.getCoordinates().getCoordinates().get(0));
    assertEquals(lat, tweet.getCoordinates().getCoordinates().get(1));

    assertTrue(hashTag.contains(tweet.getEntities().getHashtags().get(0).getText()));
  }

  @Test
  public void deleteTweet() {
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;

    Tweet tweet =
        controller.postTweet(new String[]{"post", text, String.format("%s:%s", lat, lon)});
    List<Tweet> tweets =
        controller.deleteTweet(new String[]{"delete", String.format("%s", tweet.getId_str())});

    assertEquals(text, tweets.get(0).getText());

    assertNotNull(tweets.get(0).getCoordinates());
    assertEquals(2, tweets.get(0).getCoordinates().getCoordinates().size());
    assertEquals(lon, tweets.get(0).getCoordinates().getCoordinates().get(0));
    assertEquals(lat, tweets.get(0).getCoordinates().getCoordinates().get(1));

    assertTrue(hashTag.contains(tweets.get(0).getEntities().getHashtags().get(0).getText()));
  }
}
