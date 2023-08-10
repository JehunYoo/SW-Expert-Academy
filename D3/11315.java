import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
 
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[][] board = new String[N][N];
 
            for(int i=0; i<N; i++) {
                board[i] = br.readLine().split("");
            }
            boolean isCont = false;
 
            // row
            for(int row=0; row<N; row++) {
                int count = 0;
                for(int i=0; i<N; i++) {
                    if(board[row][i].equals("o")) {
                        count++;
                    } else if(count >= 5) {
                        isCont = true;
                        break;
                    } else {
                        count = 0;
                    }
                }
                if(count >= 5)
                    isCont = true;
                if(isCont)
                    break;
            }
            if(isCont) {
                bw.write("#" + t + " YES\n");
                continue;
            }
            // col
            for(int col=0; col<N; col++) {
                int count = 0;
                for(int i=0; i<N; i++) {
                    if(board[i][col].equals("o")) {
                        count++;
                    } else if(count >= 5) {
                        isCont = true;
                        break;
                    } else {
                        count = 0;
                    }
                }
                if(count >= 5)
                    isCont = true;
                if(isCont)
                    break;
            }
            if(isCont) {
                bw.write("#" + t + " YES\n");
                continue;
            }
            // diagonal
            for(int d=0; d<N+N-1; d++) {
                int count = 0;
                for(int i=0; i<N; i++) {
                    int x = d - i;
                    int y = i;
                    if(0 <= x && x < N && board[x][y].equals("o")) {
                        count++;
                    } else if(count >= 5) {
                        isCont = true;
                        break;
                    } else {
                        count = 0;
                    }
                }
                if(count >= 5)
                    isCont = true;
                if(isCont)
                    break;
            }
            if(isCont) {
                bw.write("#" + t + " YES\n");
                continue;
            }
            // diagonal
            for(int d=-(N-1); d<N; d++) {
                int count = 0;
                for(int i=0; i<N; i++) {
                    int x = d + i;
                    int y = i;
                    if(0 <= x && x < N && board[x][y].equals("o")) {
                        count++;
                    } else if(count >= 5) {
                        isCont = true;
                        break;
                    } else {
                        count = 0;
                    }
                }
                if(count >= 5)
                    isCont = true;
                if(isCont)
                    break;
            }
            if(isCont) {
                bw.write("#" + t + " YES\n");
                continue;
            }
 
            bw.write("#" + t + " NO\n");
        }
 
        bw.flush();
        bw.close();
    }
}