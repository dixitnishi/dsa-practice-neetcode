class Pair{
    int pos;
    int sp;
    public Pair(int pos,int sp){
        this.pos = pos;
        this.sp = sp;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0;i<n;i++){
            pairs.add(new Pair(position[i],speed[i]));
        }
        pairs.sort((a,b) -> Integer.compare(b.pos,a.pos));
        double maxUntill = -1;
        int countFleets = 0;
        for(Pair pair:pairs){
            double time = (double)(target - pair.pos)/pair.sp;
            if(time > maxUntill){
                countFleets++;
                maxUntill = time;
            }
        }
        return countFleets;
    }
}
