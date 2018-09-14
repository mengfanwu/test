package leetcode;

public class MostWater {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int s = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
            int a = height[i];
            int b = height[j];
            int w = j - i;
            int h;
            if(a > b){
                h = b;
                j --;
            }else{
                h = a;
                i ++;
            }
            int wh = w * h;
            if( wh > s) s = wh;

        }
        return s;
    }
}
