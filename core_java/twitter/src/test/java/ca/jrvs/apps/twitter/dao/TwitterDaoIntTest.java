package ca.jrvs.apps.twitter.dao;

public class TwitterDaoIntTest {

  private TwitterDao twitterDao;

  @Before
  public void setUp() {
    String consumerKey = System.getenv("consumerKey");
    String consumerSecret = System.getenv("consumerSecret");
    String accessToken = System.getenv("accessToken");
    String tokenSecret = System.getenv("tokenSecret");
    System.out.println(consumerKey + "|" + consumerSecret + "|" + accessToken + "|" + tokenSecret);
    //set up dependency
    HttpHelper httpHelper = new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    //pass dependency
    this.dao = new TwitterDao(httpHelper);
  }

  @Test
  public void create() throws Exception {

  }
}