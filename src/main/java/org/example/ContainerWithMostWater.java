package org.example;

class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left=0;
        int right=heights.length-1;
        while(left<right){
            int length = right-left;
            if(heights[left]<heights[right]){
                // max area possible with left bar as length is maximum
                int area = heights[left]*length;
                maxArea = Math.max(maxArea,area);
                left++;
            }else if(heights[right]<heights[left]){
                // max area possible with right bar as length is maximum
                int area = heights[right]*length;
                maxArea = Math.max(maxArea,area);
                right--;
            }else{
                int area = heights[right]*length;
                maxArea = Math.max(maxArea,area);
                right--;
                left++;
            }

        }
        return maxArea;

    }
}

