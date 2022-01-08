package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@org.springframework.stereotype.Controller
public class TwitterController implements Controller {

  private static final String COORD_SEP = ":";
  private static final String COMMA = ",";

  private Service service;

  @Autowired
  public TwitterController(Service service) { this.service = service; }

  @Override
  public Tweet postTweet(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException(
          "USAGE: TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
    }

    String tweet_txt = args[1];
    String coord = args[2];
    String[] coordArray = coord.split(COORD_SEP);
    if (coordArray.length != 2 || StringUtils.isEmpty(tweet_txt)) {
      throw new IllegalArgumentException(
          "Invalid location format\nUSAGE: " +
              "TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"");
    }
    Double lat;
    Double lon;
    try {
      lat = Double.parseDouble(coordArray[0]);
      lon = Double.parseDouble(coordArray[1]);
    } catch (Exception ex) {
      throw new IllegalArgumentException(
          "Invalid location format\nUSAGE: " +
              "TwitterCLIApp post \"tweet_text\" \"latitude:longitude\"", ex);
    }

    Tweet postTweet = TweetUtil.buildTweet(tweet_txt, lon, lat);
    return service.postTweet(postTweet);
  }

  @Override
  public Tweet showTweet(String[] args) {
    if (args.length != 3) {
      throw new IllegalArgumentException(
          "Invalid arguments\nUSAGE: TwitterCLIApp show \"tweet_id\" \"field1:field2\"");
    }

    String id = args[1];
    String[] fields = args[2].split(COMMA);

    return service.showTweet(id, fields);
  }

  @Override
  public List<Tweet> deleteTweet(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException(
          "Invalid arguments\nUSAGE: TwitterCLIApp delete \"tweet_id\" \"id1:id2\"");
    }

    String[] ids = args[1].split(COMMA);

    return service.deleteTweets(ids);
  }
}
