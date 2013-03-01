// 10189 Minesweeper
import java.util.*;
public class Mine {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int cases = 1;
        while (true) {
        
            int n = input.nextInt();
            int m = input.nextInt();
            if (n + m == 0) return;
            
            input.nextLine();
            if (cases != 1) System.out.println();
            
            int[][] board = new int[n + 2][m + 2];
            
            for (int i = 1; i <= n; ++i) {
                String s = input.nextLine();
                for (int j = 1; j <= m; ++j) {
                    char t = s.charAt(j - 1);
                    if (t == '*') {
                        board[i][j] = -1;
                        if (board[i + 1][j] != -1) ++board[i + 1][j];
                        if (board[i - 1][j] != -1) ++board[i - 1][j];
                        if (board[i][j + 1] != -1) ++board[i][j + 1];
                        if (board[i][j - 1] != -1) ++board[i][j - 1];
                        if (board[i + 1][j + 1] != -1) ++board[i + 1][j + 1];
                        if (board[i + 1][j - 1] != -1) ++board[i + 1][j - 1];
                        if (board[i - 1][j + 1] != -1) ++board[i - 1][j + 1];
                        if (board[i - 1][j - 1] != -1) ++board[i - 1][j - 1];
                    }
                }
            }
            System.out.println("Field #" + cases + ":");
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= m; ++j) {
                    System.out.print(board[i][j] == -1 ? "*" : board[i][j]);
                }
                System.out.println();
            }
            ++cases;
        }
    }
}
