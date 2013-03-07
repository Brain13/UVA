// Unidirectional TSP
import java.util.*;
public class TSP {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        while (input.hasNext()) {
        
            int m = input.nextInt();
            int n = input.nextInt();
            
            int[][] grid = new int[m][n];
            
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = input.nextInt();
                }
            }
        
            // set the solution grid
            // column 1 is the input column
            int[][] solution = new int[m][n];
            for (int i = 0; i < m; ++i)
                solution[i][0] = grid[i][0];
                
            // remaining columns are based on mountain climber
            for (int j = 1; j < n; ++j) {
                for (int i = 0; i < m; ++i) {
                    int curr = grid[i][j];
                    int up;
                    if (i - 1 >= 0)
                        up = solution[i - 1][j - 1];
                    else
                        up = solution[m - 1][j - 1];
                    int mid = solution[i][j - 1];
                    int down;
                    if (i + 1 < m)
                        down = solution[i + 1][j - 1];
                    else
                        down = solution[0][j - 1];
                        
                    //System.out.println(up + " " + mid + " " + down);
                        
                    solution[i][j] = Math.min(up, Math.min(mid, down)) + curr;
                }
            }
            
            /*for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    System.out.print(solution[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();*/
            
            int answer = solution[0][n - 1];
            for (int i = 0; i < m; ++i) {
                answer = Math.min(answer, solution[i][n - 1]);
            }
            
			int path = -1;
            for (int i = 0; i < m; ++i) {
				if (solution[i][n - 1] == answer) {
					int temp = solve(solution, i, n - 1, path);
				}
			}
            
            System.out.println(answer);
            //System.out.println();
        
        }
    }
	
	public static int solve(int[][] solution, int i, int j, int path) {
	
		// find best of up, mid, and down
		int up;
		int upIndex;
        if (i - 1 >= 0) {
            up = solution[i - 1][j - 1];
			upIndex = i - 1;
        else {
			up = solution[solution.length - 1][j - 1];
			upIndex = solution.length - 1;
		}
		int mid = solution[i][j - 1];
		int down;
		int downIndex;
		if (i + 1 < solution.length) {
			down = solution[i + 1][j - 1];
			downIndex = i + 1;
		}
		else {
			down = solution[0][j - 1];
			downIndex = 0;
		}
		
		int min = Math.min(up, Math.min(mid, down));
		if (path == -1)
			path = i;
		else
			path = path * 10 + i;
		
		// go up, mid, and down
		if (solution[upIndex][j - 1] == min)
			solve(solution, upIndex, j - 1);
		if (solution[i][j - 1] == min)
			solve(solution, i, j - 1);
		if (solution[downIndex][j - 1] == min)
			solve(solution, downIndex, j - 1);
		
		return 0;
	
	}
}
