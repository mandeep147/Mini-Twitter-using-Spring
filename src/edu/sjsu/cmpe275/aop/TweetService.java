package edu.sjsu.cmpe275.aop;

import java.io.IOException;

public interface TweetService {
   /**
    * @throws IllegalArgumentException if the message is more than 140 characters as measured by string length.
    * @throws IOException if there is a network failure
    */
   void tweet(String user, String message) throws IllegalArgumentException, IOException;
   /**
    * @throws IOException if there is a network failure
    */
   void follow(String follower, String followee) throws IOException;
}