package ca.jrvs.apps.practice;

import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc {
  
  public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
  
  /**
   * return true if filename extension is jpg or jpeg (case insensitive)
   * @param filename
   * @return
   */
  public boolean matchJpeg(String filename) {
    String jpg = ".*.(?i)jpg$";
    String jpeg = ".*.(?i)jpeg$";
    return Pattern.matches(jpg, filename) || Pattern.matches(jpeg, filename);
  };
  
  /**
   * return true if ip is valid
   * to simplify the problem, IP address range is from 0.0.0.0 to 999.999.999.999
   * @param ip
   * @return
   */
  public boolean matchIp(String ip) {
    String pattern = "((0|([1-9]{1,3})).){3}(0|([1-9]{1,3}))";
    return Pattern.matches(pattern, ip);
  };
  
  /**
   * return true if line is empty (e.g. empty, white space, tabs, etc..)
   * @param line
   * @return
   */
  public boolean isEmptyLine(String line) {
    String pattern = "^\\s*$";
    return Pattern.matches(pattern, line);
  };
}
