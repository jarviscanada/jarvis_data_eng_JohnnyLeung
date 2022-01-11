package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceUnitTest {

  @Mock
  CrdDao dao;

  @InjectMocks
  TwitterService service;

  @Test
  public void postTweet() {
    //test failed request
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    //exception is expected here
    when(dao.create(isNotNull())).thenThrow(new RuntimeException("mock"));
    try {
      service.postTweet(TweetUtil.buildTweet(text, lon, lat));
      fail();
    } catch (RuntimeException ex) {
      assertTrue(true);
    }

    when(dao.create(any())).thenReturn(new Tweet());
    Tweet tweet = service.postTweet(TweetUtil.buildTweet("test", 50.0, 0.0));
    assertNotNull(tweet);
  }

  @Test
  public void showTweet() {
    //test failed request
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;

    Tweet tweet = TweetUtil.buildTweet(text, lon, lat);
    try {
      service.showTweet(tweet.getId_str(), new String[]{});
      fail();
    } catch (RuntimeException ex) {
      assertTrue(true);
    }

    when(dao.findById(any())).thenReturn(new Tweet());
    tweet = service.showTweet(tweet.getId_str(), new String[]{});
    assertNotNull(tweet);
  }

  @Test
  public void deleteTweets() {
    //test failed request
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;

    Tweet tweet = TweetUtil.buildTweet(text, lon, lat);

    when(dao.deleteById(any())).thenReturn(tweet);
    List<Tweet> tweets = service.deleteTweets(new String[]{tweet.getId_str()});
    assertNotNull(tweet);
    assertEquals(1, tweets.size());
  }
}
