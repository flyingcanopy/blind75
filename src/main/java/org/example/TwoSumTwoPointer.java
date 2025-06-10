package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumTwoPointer {
    public int[] twoSum(int[] numbers, int target) {

        int left=0;
        int right=numbers.length-1;
        while(left<right) {
            int sum = numbers[left] + numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[2];


    }
    public List<List<Integer>> twoSumDuplicates(int[] numbers, int target) {

        int left=0;
        int right=numbers.length-1;
        List<List<Integer>> pairs = new ArrayList();
        while(left<right) {
            int sum = numbers[left] + numbers[right];
            if(sum==target){
                //found one pair
                List<Integer> pair = new ArrayList<>();
                pair.add(numbers[left]);
                pair.add(numbers[right]);
                pairs.add(pair);
                left++;
                right--;
                while(left<numbers.length&&numbers[left]==numbers[left-1])
                    left++;
                while(right>=0&&numbers[right]==numbers[right+1])
                    right--;
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return pairs;

    }

public static void main(String[] args) {
    TwoSumTwoPointer twoSumTwoPointer = new TwoSumTwoPointer();
    int target = 6;
    for(List<Integer> pair:twoSumTwoPointer.twoSumDuplicates(new int[]{-1,1,2,3,4,5,6,7},target))
    {
        System.out.println(pair);

    }
}
}
