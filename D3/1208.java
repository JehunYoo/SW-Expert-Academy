import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        for(int t=1; t<=10; t++) {
            int dump = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            int[] height = new int[in.length];
            for(int i=0; i<in.length; i++)
                height[i] = Integer.parseInt(in[i]);
 
            // sort
            for(int i=0; i<height.length; i++) {
                int min = height[i];
                int arg = i;
                for(int j=i+1; j< height.length; j++) {
                    if(height[j] < min) {
                        min = height[j];
                        arg = j;
                    }
                }
                if(i < arg) {
                    int temp = height[i];
                    height[i] = min;
                    height[arg] = temp;
                }
            }
 
            while(dump > 0) {
                height[0]++;
                height[height.length - 1]--;
 
                for(int i=1; i<height.length; i++) {
                    if(height[i] < height[0]) {
                        int temp = height[0];
                        height[0] = height[i];
                        height[i] = temp;
                        break;
                    }
                }
                for(int i=height.length-2; i>=0; i--) {
                    if(height[height.length - 1] < height[i]) {
                        int temp = height[height.length - 1];
                        height[height.length - 1] = height[i];
                        height[i] = temp;
                        break;
                    }
                }
 
                if(height[height.length - 1] == height[0])
                    break;
 
                dump--;
            }
 
 
            bw.write("#" + t + " " + (height[height.length - 1] - height[0]) + "\n");
            bw.flush();
        }
 
        bw.close();
    }
}