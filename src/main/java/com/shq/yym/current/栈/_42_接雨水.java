package com.shq.yym.current.栈;

/**
 * @ClassName: _42_接雨水
 * @Description: 42. 接雨水
 * @author: sihanqiu
 * @date: 2020年07月21日 16:12
 */
public class _42_接雨水 {

    public int trap(int[] height) {

        int j = height.length - 1;
        int i = 0;
        int val = 0;
        int score = 0;
        int sum = 0;
         while(i <= j) {
             if(height[i] <= val) {
                 sum += height[i];
                 i++;
             } else {
                 if(height[j] <= val) {
                     sum += height[j];
                     j--;
                 } else {
                   if(height[i] > height[j]) {
                       score += (height[j] - val) * (j - i + 1);
                       val = height[j];
                       sum += height[j];
                       j--;
                   } else if(height[i] < height[j]) {
                       score += (height[i] - val) * (j - i + 1);
                       val = height[i];
                       sum += height[i];
                       i++;
                   } else {
                       score += (height[i] - val) * (j - i + 1);
                       val = height[i];
                       if(i != j) { // 当 i != j 时，将 j 元素的值 加上
                           sum += height[j];
                       } // i == j 时只需要加一次值
                       sum += height[i];
                       i++;
                       j--;
                   }
                 }
             }
         }
        return score - sum;
    }
}
