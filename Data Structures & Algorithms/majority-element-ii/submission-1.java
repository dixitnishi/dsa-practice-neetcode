class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int elem1 = Integer.MIN_VALUE;
        int elem2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(count1 == 0 && num != elem2){
                elem1 = num;
                count1++;
            }
            else if(count2 == 0 && num != elem1){
                elem2 = num;
                count2++;
            }
            else if(num == elem1){
                count1++;
            }
            else if(num == elem2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        // at this point we have figured out the candidates
        // now we just need to check whether they are really the candidates having majority
        // occurances
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == elem1) count1++;
            if(num == elem2) count2++;
        }
        int threshold = nums.length/3 + 1;
        if(count1 >= threshold){
            ans.add(elem1);
        }
        if(count2 >= threshold && elem1 != elem2){
            ans.add(elem2);
        }
        return ans;
    }
}