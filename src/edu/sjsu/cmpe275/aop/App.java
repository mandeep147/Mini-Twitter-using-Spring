package edu.sjsu.cmpe275.aop;

public class App {
	public static void main(String[] args) {
		TweetService tweeter = new TweetServiceImpl();
		TweetStats tweetStats = new TweetStatsImpl();
		try {
			tweeter.tweet("alex", "firsttweet");
			tweeter.follow("alice", "bob");
			tweeter.tweet("bob", "second");
			tweeter.follow("bob", "charlie");
			tweeter.follow("bob", "alice");
			//tweeter.tweet("alex", "cS6JDD4vYh0VoaxaE69ksiWvkleCHE9al");
			tweeter.tweet("carl", "final tweet");
			
			tweeter.tweet("foo", "barbar");
			
			tweeter.follow("alice", "bob");
			tweeter.follow("charlie", "alice");
			tweeter.follow("bob", "charlie");
			tweeter.follow("bob", "dan");
			tweeter.follow("bob", "m");
			tweeter.follow("bob", "n");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Most productive user: " + tweetStats.getMostProductiveUser());
		System.out.println("Most followed user: " + tweetStats.getMostActiveFollower());
		System.out.println("Length of the longest tweet: " + tweetStats.getLengthOfLongestTweet());
	}
}