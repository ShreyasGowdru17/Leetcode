import java.time.LocalDateTime;
class Twitter {
        private Map<Integer,Set<Integer>> followers;
        private Map<Integer,List<Tweet>> tweets;
        int time=0;
    public Twitter() {
        followers=new HashMap<>();
        tweets=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId,new ArrayList<>());
        }
        tweets.get(userId).add(new Tweet(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed=new ArrayList<>();
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->b.time-a.time);
        if(tweets.containsKey(userId)){
            pq.addAll(tweets.get(userId));
        }

        if(followers.containsKey(userId)){
            for(int followee:followers.get(userId)){
                if(tweets.containsKey(followee)){
                    pq.addAll(tweets.get(followee));
                }
            }
        }

        int count=0;
        while(!pq.isEmpty() && count<10){
            feed.add(pq.poll().tweetId);
            count++;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId,new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId) && followerId!=followeeId){
            followers.get(followerId).remove(followeeId);
        }
    }
}
class Tweet{
    int tweetId;
    int time;
    Tweet(int tweetId,int time){
        this.tweetId=tweetId;
        this.time=time;
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */