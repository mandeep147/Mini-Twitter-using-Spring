package edu.sjsu.cmpe275.aop;

public interface TweetStats {

	/**
	 * reset all the three measurements.
	 */

	void resetStats();

	/**
	 * @return the length of longest message successfully tweeted since the beginning or last reset. If no messages were successfully tweeted, return 0.
	 */
	int getLengthOfLongestTweet();
	/**
	 * @return the user who has attempted to follow the biggest number of different users since
	 * the beginning or last reset. If there is a tie, return the 1st of such users based on
	 * alphabetical order. Even if the follow action did not succeed, it still counts toward the stats.
	 * If no users attempted to follow anybody, return null.  
	 */
	String getMostActiveFollower();
	/**
	 * The most productive user is determined by the total length of all the messages successfully tweeted since the beginning
	 * or last reset. If there is a tie, return the 1st of such users based on alphabetical order. If no users successfully tweeted, return null.
	 * @return the most productive user.
	 */
	String getMostProductiveUser();
}