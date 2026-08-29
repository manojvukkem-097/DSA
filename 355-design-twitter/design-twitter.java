class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int time,int tweetId){
        this.time=time;
        this.tweetId=tweetId;
    }
    @Override
    public int compareTo(Tweet that){
        return that.time-this.time;
    }
}
class User{
    int userId;
    Set<Integer>followees;
    List<Tweet>tweets;
    User(int userId){
        this.userId=userId;
        followees=new HashSet<>();
        followees.add(userId);
        tweets=new LinkedList<>();
    }
    public void post(Tweet t){
        tweets.add(0,t);
    }
    public void addfollower(int followeeId){
        followees.add(followeeId);
    }
    public void removefollower(int followeeId){
        if(followeeId!=userId){
            followees.remove(followeeId);
        }
    }
}
class Twitter {
    private Map<Integer,User>UserMap;
    private int timestamp;
    public Twitter() {
        UserMap=new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!UserMap.containsKey(userId)){
            UserMap.put(userId,new User(userId));
        }
        timestamp++;
        Tweet t=new Tweet(timestamp,tweetId);
        UserMap.get(userId).post(t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!UserMap.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Tweet>pq=new PriorityQueue<>();
        Set<Integer>followees=new HashSet<>(UserMap.get(userId).followees);
        for(int followeeId:followees){
            User followee=UserMap.get(followeeId);
            if(followee!=null && followee.tweets!=null){
                int count=0;
                for(Tweet tweet:followee.tweets){
                    if(count<10){
                        pq.offer(tweet);
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<10;i++){
            if(!pq.isEmpty()){
                result.add(pq.poll().tweetId);
            }else{
                break;
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!UserMap.containsKey(followerId)){
            UserMap.put(followerId,new User(followerId));
        }
        if(!UserMap.containsKey(followeeId)){
            UserMap.put(followeeId,new User(followeeId));
        }
        UserMap.get(followerId).addfollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!UserMap.containsKey(followeeId)||!UserMap.containsKey(followerId)){
            return;
        }
        UserMap.get(followerId).removefollower(followeeId);
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