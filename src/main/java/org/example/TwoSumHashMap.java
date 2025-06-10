package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumHashMap {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap();
        List<List<Integer>> pairs = new ArrayList();
        for(int i=0;i<numbers.length;i++){

            if(i>0&&numbers[i]==numbers[i-1])
                continue;
            if(map.containsKey(target-numbers[i])){
                // I found a pair for numbers[i] i.e (target-numbers[i],numbers[i])
                List<Integer> pair = new ArrayList();
                pair.add(target-numbers[i]);
                pair.add(numbers[i]);
                pairs.add(pair);
                return new int[]{map.get(target-numbers[i])+1,i+1};
            }else{
                map.put(numbers[i],i);
            }

        }
        return new int[2];
    }
}
