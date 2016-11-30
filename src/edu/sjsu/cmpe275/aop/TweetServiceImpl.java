package edu.sjsu.cmpe275.aop;

import java.io.IOException;

public class TweetServiceImpl implements TweetService{
	/**
	 * @throws IllegalArgumentException if the message is more than 140 characters as measured by string length.
	 * @throws IOException if there is a network failure
	 */
	@Override
	public void tweet(String user, String message) throws IllegalArgumentException, IOException {
		if(message.length() > 140){
			throw new IllegalArgumentException();
		}

		int except = (int) Math.random();

		if( except == 32767){
			throw new IOException();
		}

	}

	/**
	 * @throws IOException if there is a network failure
	 */
	@Override
	public void follow(String follower, String followee) throws IOException {
					
		int except = (int) Math.random();

		if( except == 4573){
			throw new IOException();
		}
	}
}