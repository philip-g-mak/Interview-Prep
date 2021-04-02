class Leaderboard {
    Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        
        int res = 0;
        while (K > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res += entry.getValue();
            K--;
        }
        return res;
    }
    
    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}