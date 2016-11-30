package edu.sjsu.cmpe275.aop.aspect;

import java.io.IOException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;  

@Aspect
public class RetryAspect {
	int countTweetRetries = 0;
	int countFollowRetries = 0;

	@Around("execution(* edu.sjsu.cmpe275.aop.TweetService.tweet(..))")
	public void retryTweet(ProceedingJoinPoint pjp) throws Throwable{
		try{	
			
			countTweetRetries++;
			pjp.proceed();
			countTweetRetries = 0;		
		
		}catch(Exception e){		
			if(  e instanceof IOException || e instanceof IllegalArgumentException ){			
				
				if( countTweetRetries < 2){	
				
					retryTweet(pjp);
				
				}				
				else{
				
					throw e;
				
				}
			}
		}
	}

	@Around("execution(* edu.sjsu.cmpe275.aop.TweetService.follow(..))")
	public void retryFollow(ProceedingJoinPoint pjp) throws Throwable{

		try{
			
			countFollowRetries++;
			pjp.proceed();
			countFollowRetries = 0;

		}catch(Exception e){
			
			if(  e instanceof IOException ){	
			
				if( countFollowRetries < 2){				
				
					retryFollow(pjp);
				}				
				else{
					throw e;
				}
			}
		}
	}
}