import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int tc = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            Map<Integer, Integer> counter = new HashMap<>();
            for(String n: in) {
                int num = Integer.parseInt(n);
                if(counter.containsKey(num)) {
                    counter.put(num, counter.get(num) + 1);
                } else {
                    counter.put(num, 1);
                }
            }
            int most = 0, count = 0;
            for(Map.Entry<Integer, Integer> entry: counter.entrySet()) {
                if(count <= entry.getValue()) {
                    count = entry.getValue();
                    most = most < entry.getKey()? entry.getKey(): most;
                }
            }
            bw.write("#" + tc + " " + most + "\n");
        }

        bw.flush();
        bw.close();
    }
}