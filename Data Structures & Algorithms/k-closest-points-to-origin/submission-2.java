class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // using min heap
        // store the min distance and index of the points in min heap
        // calculate the distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> Double.compare(p1.distance,p2.distance));

        for(int i = 0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double distance = (x * x) + (y * y);
            pq.offer(new Pair(i,distance));
        }
        int ans[][] = new int[k][2];
        for(int i = 0;i<k;i++){
            Pair p = pq.poll();
            ans[i] = points[p.idx];
        }
        return ans;
        
    }
}

class Pair{
    int idx;
    double distance;

    public Pair(int idx,double distance){
        this.idx = idx;
        this.distance = distance;
    }
}
