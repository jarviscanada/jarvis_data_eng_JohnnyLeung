package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@org.springframework.stereotype.Service
public class TwitterService implements Service {

  private CrdDao dao;

  @Autowired
  public TwitterService(CrdDao dao) { this.dao = dao; }

  @Override
  public Tweet postTweet(Tweet tweet) {
    //Business logic:
    //e.g. text length, lat/lon range, id format
    validatePostTweet(tweet);

    //create tweet via doa
    return (Tweet) dao.create(tweet);
  }

  public void validatePostTweet(Tweet tweet) {
    try {
      if (tweet.getText().length() > 280) {
        throw new IllegalArgumentException
            ("The text content of a Tweet can contain up to 280 characters");
      }
      if (tweet.getCoordinates().getCoordinates().size() != 2) {
        throw new IllegalArgumentException("Coordinates must contain exactly two values");
      }
      double lon = tweet.getCoordinates().getCoordinates().get(0);
      double lat = tweet.getCoordinates().getCoordinates().get(1);
      if (lon < -180 || lon > 180) {
        throw new IllegalArgumentException("Longitude value is out of range");
      }
      if (lat < -90 || lat > 90) {
        throw new IllegalArgumentException("Latitude value is out of range");
      }
    } catch (NullPointerException ex) {
      throw new IllegalArgumentException("Longitude and latitude values required", ex);
    }
  }

  @Override
  public Tweet showTweet(String id, String[] fields) {
    validateTweetId(id);
    Tweet tweet = (Tweet) dao.findById(id);
    return tweet;
  }

  public void validateTweetId(String id) {
    try {
      Long.parseLong(id);
    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException("Tweet ID must be a 64-bit integer", ex);
    }
  }

  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    for (String id : ids) {
      validateTweetId(id);
    }
    List<Tweet> tweets = new ArrayList<>();
    for (String id : ids) {
      tweets.add((Tweet) dao.deleteById(id));
    }
    return tweets;
  }
}