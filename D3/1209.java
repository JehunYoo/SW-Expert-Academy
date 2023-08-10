import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 100;

        for(int t=1; t<=10; t++) {
            int T = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++) {
                String[] in = br.readLine().split(" ");
                for(int j=0; j<N; j++)
                    arr[i][j] = Integer.parseInt(in[j]);
            }

            int sum = 0;
            for(int i=0; i<N; i++)
                sum += arr[i][i];
            int answer = sum;
            
            sum = 0;
            for(int i=0; i<N; i++)
                sum += arr[N-1-i][i];
            answer = answer < sum? sum: answer;

            for(int i=0; i<N; i++) {
                sum = 0;
                for(int j=0; j<N; j++)
                    sum += arr[i][j];
                answer = answer < sum? sum: answer;
            }
            for(int i=0; i<N; i++) {
                sum = 0;
                for(int j=0; j<N; j++)
                    sum += arr[j][i];
                answer = answer < sum? sum: answer;
            }

            bw.write("#" + T + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}