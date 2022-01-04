package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import com.google.gdata.util.common.base.PercentEscaper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

@Repository
public class TwitterDao implements CrdDao<Tweet, String> {

  //URI constants
  private static final String API_BASE_URI = "https://api.twitter.com";
  private static final String POST_PATH = "/1.1/statuses/update.json";
  private static final String SHOW_PATH = "/1.1/statuses/show.json";
  private static final String DELETE_PATH = "/1.1/statuses/destroy";
  //URI symbols
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";

  //Response code
  private static final int HTTP_OK = 200;

  private HttpHelper httpHelper;

  @Autowired
  public TwitterDao(HttpHelper httpHelper) { this.httpHelper = httpHelper; }

  @Override
  public Tweet create(Tweet tweet) {
    //Construct URI
    URI uri;
    try {
      uri = getPostUri(tweet);
    } catch (URISyntaxException ex) {
      throw new IllegalArgumentException("Invalid Tweet input", ex);
    }

    //Execute HTTP Request
    HttpResponse httpResponse = httpHelper.httpPost(uri);

    //Validate response and deser response to Tweet object
    return parseResponseBody(httpResponse, HTTP_OK);
  }

  @Override
  public Tweet findById(String id) {
    URI uri;
    try {
      uri = new URI(API_BASE_URI + SHOW_PATH + QUERY_SYM + "id" + EQUAL + id);
    } catch (URISyntaxException ex) {
      throw new RuntimeException("Could not create URI", ex);
    }
    HttpResponse response = httpHelper.httpGet(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  @Override
  public Tweet deleteById(String id) {
    URI uri;
    try {
      uri = new URI(API_BASE_URI + DELETE_PATH + "/" + id + ".json");
    } catch (URISyntaxException ex) {
      throw new RuntimeException("Could not create URI", ex);
    }
    HttpResponse response = httpHelper.httpPost(uri);
    return parseResponseBody(response, HTTP_OK);
  }

  /**
   * Check response status code Convert Response Entity to Tweet
   */
  private Tweet parseResponseBody(HttpResponse httpResponse, Integer expectedResponseCode) {
    Tweet tweet = null;

    //Check response status
    int status = httpResponse.getStatusLine().getStatusCode();
    if (status != expectedResponseCode) {
      try {
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
      } catch (IOException ex) {
        System.out.println("Response has no entity");
      }
      throw new RuntimeException("Unexpected HTTP status: " + status);
    }

    if (httpResponse.getEntity() == null) {
      throw new RuntimeException("Empty response body");
    }

    //Convert response body to str
    String jsonStr;
    try {
      jsonStr = EntityUtils.toString(httpResponse.getEntity());
    } catch (IOException ex) {
      throw new RuntimeException("Failed to convert entity to String", ex);
    }

    //Deser JSON String to Tweet object
    try {
      tweet = JsonUtil.toObjectFromJson(jsonStr, Tweet.class);
    } catch (IOException ex) {
      throw new RuntimeException("Unable to convert JSON str to Object", ex);
    }

    return tweet;
  }

  public URI getPostUri(Tweet tweet) throws URISyntaxException {
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    URI uri;
    try {
      uri = new URI(API_BASE_URI + POST_PATH + QUERY_SYM + "status" + EQUAL +
              percentEscaper.escape(tweet.getText()) + AMPERSAND + "long" + EQUAL +
              tweet.getCoordinates().getCoordinates().get(0).toString() + AMPERSAND + "lat" + EQUAL +
              tweet.getCoordinates().getCoordinates().get(1).toString());
    } catch (URISyntaxException ex) {
      throw new RuntimeException("Could not create URI", ex);
    }
    return uri;
  }
}