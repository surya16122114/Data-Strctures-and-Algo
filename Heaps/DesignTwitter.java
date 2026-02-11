package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
    class Twitter {
    private static int timeStamp=0;
    private class Tweet{
        int time;
        int tweetId;
//This points to the next tweet of the followee
        Tweet next;

        public Tweet(int id, int time){
            this.time=time;
            this.tweetId=id;
            next=null;
        }
    }

    //follower, set of followees
Map<Integer, Set<Integer>> followMap;
//user and his tweets
Map<Integer, Tweet> tweetMap;
    public Twitter() {
        followMap=new HashMap<>();
        tweetMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet=new Tweet(tweetId, timeStamp++);

        //if this is not the first post of the user then add as next tweet to the existing tweets of the user

        if(tweetMap.containsKey(userId))
        //we are storing the tweet with highest time first becuase it is the new tweet
        //so map the existing tweets as next of this tweet 
        tweet.next=tweetMap.get(userId);
//if this is the first tweet of the user then just add it to the tweet map
        tweetMap.put(userId, tweet);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        //we need to show the 10 most recent tweets for the user with user id=userId

        //if the user is not following anybody

        if(!followMap.containsKey(userId))
        followMap.put(userId, new HashSet<>()) ;
        //now self follow;

        followMap.get(userId).add(userId) ;
    //max heap
        PriorityQueue<Tweet> pq=  new PriorityQueue<>((a,b)->b.time-a.time);

        for(int followeeId: followMap.get(userId)) {
            //for each followee we are adding the tweets if the that followee has posted anything
            if(tweetMap.containsKey(followeeId))
            pq.offer(tweetMap.get(followeeId));

            //so here in the priority queue, we are storing the head of the each users tweet linked list

            //{1, 9-->2,5}, {7, 8--->9, 4}
            //so each users tweet linked list os stored based on the time
        }   
List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty() && ans.size()<10){
           Tweet tweet= pq.poll();
           ans.add(tweet.tweetId);
//see if the user has mutiple tweets, we are adding to the queue again, because we did not sort the each users tweet.
           if(tweet.next!=null)
           pq.add(tweet.next);

        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        //we are self following in getNews feed, becuaee one should see their own posts..if we dont make the second condition here
        //user may unfollow themselves and they may not see their own posts
        if(followMap.containsKey(followerId) && followeeId!=followerId)
        followMap.get(followerId).remove(followeeId);
        
    }
}

}
