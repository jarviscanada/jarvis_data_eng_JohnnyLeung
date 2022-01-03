package ca.jrvs.apps.twitter.dao.helper;

public class TwitterHttpHelper implements HttpHelper {

  public class TwitterHttpHelper implements HttpHelper {

    /**
     * Dependencies are specified as private member variables
     */
    private OAuthConsumer consumer;
    private HttpClient httpClient;

    /**
     * Constructor
     * Setup dependencies using secrets
     *
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param tokenSecret
     */
    public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
      consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
      consumer.setTokenWithSecret(accessToken, tokenSecret);
      httpClient = new DefaultHttpClient();
    }

    @Override
    public HttpResponse httpGet(URI uri) {
      try {
        return executeHttpRequest(HttpMethod.GET, uri, null);
      } catch (IOException | OAuthException ex) {
        throw new RuntimeException("Failed to execute", ex);
      }
    }

    @Override
    public HttpResponse httpPost(URI uri) {
      try {
        return executeHttpRequest(HttpMethod.POST, uri, null);
      } catch (IOException | OAuthException ex) {
        throw new RuntimeException("Failed to execute", ex);
      }
    }

    private HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity)
            throws IOException, OAuthException {
      if (method == HttpMethod.GET) {
        HttpGet request = new HttpGet(uri);
        consumer.sign(request);
        return httpClient.execute(request);
      } else if (method == HttpMethod.POST) {
        HttpPost request = new HttpPost(uri);
        if (stringEntity != null) {
          request.setEntity(stringEntity);
        }
        consumer.sign(request);
        return httpClient.execute(request);
      } else {
        throw new IllegalArgumentException("Unknown HTTP Method: " + method.name());
      }
    }
  }
}