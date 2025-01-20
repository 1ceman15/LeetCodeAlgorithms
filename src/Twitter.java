//https://leetcode.com/problems/design-twitter/description/

import java.util.*;

public class Twitter {
    int time;
    HashMap<Integer, List<int[]>> tweets;
    HashMap<Integer, HashSet<Integer>> subs;
    public Twitter() {
        this.time = 0;
        this.tweets = new HashMap<>();
        this.subs = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time--, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        subs.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followeeId: subs.get(userId)) {
            if (tweets.containsKey(followeeId)) {
                List<int[]> helper = tweets.get(followeeId);
                int index = helper.size() - 1;
                int[] tweet = helper.get(index);
                q.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!q.isEmpty() && result.size() < 10){
            int[] CurTweet = q.poll();
            result.add(CurTweet[1]);
            int index = CurTweet[3];
            if(index > 0){
                int[] tweet = tweets.get(CurTweet[2]).get(index-1);
                q.offer(new int[]{tweet[0], tweet[1], CurTweet[2] ,index-1});
            }


        }


        return result;
    }

    public void follow(int followerId, int followeeId) {
        subs.putIfAbsent(followerId, new HashSet<>());
        subs.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        subs.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}
