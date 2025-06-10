package org.example;

import java.util.*;

public class ThreeSum {
    private Set<List<Integer>> getTriplet(int[] nums,int num,int target,int i){
        Set<List<Integer>> threeSum = new HashSet<>();
        Set<Integer> mySet = new HashSet<>();
        // if target-nums[i] exists then
        for(;i<nums.length;i++){
            if(mySet.contains(target-nums[i])){
                List<Integer> pair = new ArrayList<>(Arrays.asList(nums[i], target - nums[i]));
                // make this pair a triplet.
                pair.add(num);
                Collections.sort(pair);
                threeSum.add(pair);

            }else
                mySet.add(nums[i]);
        }
        return threeSum;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            // get all 2sums whose target == -nums[i]
            //{[1,2,3],[4,5,7],...}
            triplets.addAll(getTriplet(nums,nums[i],-1*nums[i],i+1));
        }
        return triplets.stream().toList();

    }
    public List<List<Integer>> getTriplets(List<Integer> numbers){
        // [] empty
        List<List<Integer>> triplets = new ArrayList<>();
        for(int i=0;i<numbers.size()-2;i++){
            for(int j=i+1;j<numbers.size()-1;j++){
                for(int k=j+1;k<numbers.size();k++){
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(numbers.get(i), numbers.get(j), numbers.get(k)));
                    triplets.add(triplet);
                }
            }
        }
        return triplets;
    }
    public List<List<Integer>> threeSum2Pointer(int[] nums,int target){
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int left=0;
            int right=nums.length-1;
            // reduce to 2sum where such that nums[left] + nums[right] = target-nums[i];
            int targetSum=target-nums[i];
            while(left<right){
                int sum = nums[left] + nums[right];
                if(sum==targetSum){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[left]);
                    pair.add(nums[right]);
                    pairs.add(pair);
                    left++;
                    right--;
                    while(left<nums.length&&nums[left]==nums[left-1])
                        left++;
                    while(right>=0&&nums[right]==nums[right+1])
                        right--;
                }else if(sum>targetSum){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return pairs;
    }
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int target = 6;
        for(List<Integer> triplet:threeSum.getTriplets(Arrays.asList(1,2,3,4,5,6,7))){
            int sum=0;
            for(Integer num:triplet){
               sum+=num;
            }
            if(sum==target)
                System.out.println("yes"+triplet);
        }
    }
}
