package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {

  @Mock
  Service service;

  @InjectMocks
  TwitterController controller;

  @Test
  public void postTweet() {
    //test failed request
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    try {
      controller.postTweet(new String[]{"post", text, String.format("%s:%s", lat, lon), "extra"});
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    when(service.postTweet(any())).thenReturn(new Tweet());
    Tweet tweet = controller.postTweet(
        new String[]{"post", text, String.format("%s:%s", lat, lon)});
    assertNotNull(tweet);
  }

  @Test
  public void showTweet() {
    //test failed request
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    try {
      controller.showTweet(new String[]{"show", "123456", "text, coordinates", "extra"});
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    when(service.showTweet(anyString(), any())).thenReturn(new Tweet());
    Tweet tweet = controller.showTweet(
        new String[]{"show", "123456", "text, coordinates"});
    assertNotNull(tweet);
  }

  @Test
  public void deleteTweet() {
    //test failed request
    String hashTag = "#abc";
    String text = "@someone sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    try {
      controller.deleteTweet(new String[]{"delete", "123456", "extra"});
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }

    when(service.deleteTweets(any())).thenReturn(new ArrayList<Tweet>());
    List<Tweet> tweets = controller.deleteTweet(new String[]{"delete", "123456"});
    assertNotNull(tweets);
  }
}
