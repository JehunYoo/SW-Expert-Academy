import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 100;

        for(int t=0; t<10; t++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i=0; i<N; i++) {
                String[] in = br.readLine().split(" ");
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(in[j]);
                }
            }
            int dest = -1;
            for(int j=0; j<N; j++)
                if(arr[N-1][j] == 2)
                    dest = j;
            
            int h = N - 1, w = dest;
            int head = 0;
            
            while(h > 0) {
                if(head != -1 && w + 1 < N && arr[h][w + 1] == 1) {
                    head = 1;
                    w++;
                } else if(head != 1 && w - 1 >= 0 && arr[h][w - 1] == 1) {
                    head = -1;
                    w--;
                } else if(h - 1 >= 0 && arr[h - 1][w] == 1) {
                    head = 0;
                    h--;
                }
            }
            int answer = w;

            bw.write("#" + T + " " + answer + "\n");
        }


        bw.flush();
        bw.close();
    }
}