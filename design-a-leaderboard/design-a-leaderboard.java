class Leaderboard {
    
    Map<Integer, Pair<Integer, Integer>> playMap;
    PriorityQueue<Pair<Integer, Integer>> pq;
    public Leaderboard() {
        this.playMap = new HashMap();
        this.pq = new PriorityQueue<Pair<Integer, Integer>>((a,b) -> b.getValue() - a.getValue());
        
    }
    
    public void addScore(int playerId, int score) {
        if(this.playMap.containsKey(playerId)){
            Pair<Integer, Integer> oldScore = this.playMap.get(playerId);
            Pair<Integer, Integer> newScore = new Pair(playerId, (oldScore.getValue() + score));
            
            this.playMap.put(playerId, newScore);
            this.pq.remove(oldScore);
            this.pq.add(newScore);
        } else {
            this.playMap.put(playerId, new Pair(playerId, score));
            this.pq.add(new Pair(playerId, score));
        }
    }
    
    public int top(int K) {
        List<Pair<Integer, Integer>> temp = new ArrayList();
        int sum = 0;
        for(int i = 0; i < K; i++){
            Pair<Integer, Integer> topScore = pq.poll();
            
            sum += topScore.getValue();
            
            temp.add(topScore);
        }
        
        for(int i = 0; i < temp.size(); i++){
            
            pq.add(temp.get(i));
        }
        
        return sum;
    }
    
    public void reset(int playerId) {

        int negativeScore = this.playMap.get(playerId).getValue() * -1;
        addScore(playerId, negativeScore);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */

/*
idea use hashmap and priorityqueue

HashMap will be <Player ID, Integer object>>
*/