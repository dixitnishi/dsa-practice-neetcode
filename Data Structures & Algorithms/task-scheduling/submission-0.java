class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : freq){
            if(num > 0)
                pq.offer(num);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = pq.poll() - 1;
                if(cnt > 0){
                    q.add(new int[]{cnt,time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
