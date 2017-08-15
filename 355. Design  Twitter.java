public class Twitter {

    private static int timeStamp = 0;
    private Map<Integer, User> map;

    public class User {
        public final int id;
        public Set<Integer> followee;
        public Tweet head;
        public User (int id) {
            this.id = id;
            followee = new HashSet<>();
            followee.add(id);
            head = null;
        }
        public void follow (int id) {
            followee.add(id);
        }
        public void unfollow (int id) {
            if (id != this.id) {
                followee.remove(id);
            }
        }
        public void post(int tweetId) {
            Tweet newHead = new Tweet(tweetId);
            newHead.next = this.head;
            this.head = newHead;
        }
    }

    private class Tweet implements Comparable<Tweet> {
        int tweetId;
        int time;
        Tweet next;
        public Tweet (int tweetId) {
            this.tweetId = tweetId;
            this.time = timeStamp++;
            next = null;
        }
        @Override
        public int compareTo(Tweet another) {
        	if (this.time == another.time) {
        		return 0;
        	}
        	return this.time > another.time ? -1 : 1;
        }
    }


    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<Integer, User>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = map.get(userId);
        if (user == null) {
            user = new User(userId);
            map.put(userId, user);
        }
        user.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        User user = map.get(userId);
        if (user == null) {
            user = new User(userId);
            map.put(userId, user);
        }
        Set<Integer> friendList = user.followee;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(10);
        for (Integer usId : friendList) {
        	User iter = map.get(usId);
        	if (iter.head != null) {
        		pq.offer(iter.head);
        	}
        }
        while(!pq.isEmpty() && res.size() < 10) {
        	Tweet twt = pq.poll();
        	res.add(twt.tweetId);
        	if (twt.next != null) {
        		pq.offer(twt.next);
        	}
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = map.get(followerId);
        if (follower == null) {
        	follower = new User(followerId);
            map.put(followerId, follower);
        }
        User followee = map.get(followeeId);
        if (followee == null) {
        	followee = new User(followeeId);
            map.put(followeeId, followee);
        }
        follower.follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	User follower = map.get(followerId);
        if (follower == null) {
        	follower = new User(followerId);
            map.put(followerId, follower);
        }
        User followee = map.get(followeeId);
        if (followee == null) {
        	followee = new User(followeeId);
            map.put(followeeId, followee);
        }
        follower.unfollow(followeeId);
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
