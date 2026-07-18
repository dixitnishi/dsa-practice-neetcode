class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : stones){
            pq.offer(-num);
        }
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(y > x){
                pq.offer(x - y);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
