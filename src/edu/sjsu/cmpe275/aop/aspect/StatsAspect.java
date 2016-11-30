package edu.sjsu.cmpe275.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import edu.sjsu.cmpe275.aop.TweetStatsImpl;
import edu.sjsu.cmpe275.aop.TweetStats;

@Aspect
public class StatsAspect{
	String user = "", message = "", follower = "", followee = "";

	@AfterReturning("execution(* edu.sjsu.cmpe275.aop.TweetService.tweet(..))")
	public void tweetStats(JoinPoint jp){

		TweetStats tweetStats = new TweetStatsImpl();
		Object[] args = jp.getArgs();
		
		user = args[0].toString();
		message = args[1].toString();
		
		((TweetStatsImpl) tweetStats).updateLengthOfLongestTweet(message);
		((TweetStatsImpl) tweetStats).updateMostProductiveUser(user, message);
	}

	@After("execution(* edu.sjsu.cmpe275.aop.TweetService.follow(..))")
	public void followStats(JoinPoint jp){
		TweetStats tweetStats = new TweetStatsImpl();
		Object[] args = jp.getArgs();
		
		follower = args[0].toString();
		followee = args[1].toString();
		
		((TweetStatsImpl) tweetStats).updateMostActiveFollower(follower, followee);
	}
}