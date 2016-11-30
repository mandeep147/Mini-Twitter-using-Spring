package edu.sjsu.cmpe275.aop;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class TweetStatsImpl implements TweetStats {

	static int lengthOflongestTweet;
	static TreeMap<String, Set<String>> mostFollowedUser = new TreeMap<String, Set<String>>();
	static TreeMap<String, Integer> mostProductiveUser = new TreeMap<String, Integer>();
	static Set<String> followeeSet = new TreeSet<String>();

	@Override
	public void resetStats() {
		lengthOflongestTweet = 0;
		mostFollowedUser = new TreeMap<String, Set<String>>();
		mostProductiveUser = new TreeMap<String, Integer>();
	}

	@Override
	public int getLengthOfLongestTweet() {
		return lengthOflongestTweet;
	}

	@Override
	public String getMostActiveFollower() {
		int maxFollowedUser = 0;
		String user = "";
		for (Entry<String, Set<String>> entry : mostFollowedUser.entrySet()) {
			followeeSet = entry.getValue();
			if(maxFollowedUser < followeeSet.size()){
				user = entry.getKey();
				maxFollowedUser = followeeSet.size();
			}
		}
		return user;
	}
	 
	@Override
	public String getMostProductiveUser() {
		int maxLength = 0;
		String user = "";
		for (Entry<String, Integer> entry : mostProductiveUser.entrySet()) {
			if (entry.getValue() > maxLength) {
				maxLength = entry.getValue();
				user = entry.getKey();		
			} 
		}
		return user;
	}

	public void updateLengthOfLongestTweet(String tweet){
		if(tweet.length() > lengthOflongestTweet){
			lengthOflongestTweet = tweet.length();
		}
	}

	public void updateMostProductiveUser(String user, String message){
		boolean isUserFound = false;
		for (Entry<String, Integer> entry : mostProductiveUser.entrySet()) {
			if (entry.getKey() == user) {
				isUserFound = true;
				mostProductiveUser.put(entry.getKey(), entry.getValue()+message.length());
			}
		}
		if(!isUserFound){		
			mostProductiveUser.put(user, message.length());
		}		
	}

	public void updateMostActiveFollower(String follower, String followee){
		Boolean isUserFound = false;
		Set<String> followeSet = new TreeSet<String>();
		for (Entry<String, Set<String>> entry : mostFollowedUser.entrySet()) {	
			if (entry.getKey().equals(follower)) {
				isUserFound = true;
				entry.getValue().add(followee);
			} 
		}
		if(!isUserFound) {
			followeSet.add(followee);
			mostFollowedUser.put(follower, followeSet);
		}
	} 	
}