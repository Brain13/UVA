// 1098 Robots on Ice
import java.util.*;
public class Robots {

    public static int x1;
    public static int y1;
    public static int x2;
    public static int y2;
    public static int x3;
    public static int y3;
    
    public static int s1;
    public static int s2;
    public static int s3;
    public static int s4;
    
    //public static int nextStation;
    public static int steps;
    
    public static int m;
    public static int n;
    
    public static int grid[][];

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int cases = 1;
        while (true) {
        
            // input
            m = input.nextInt();
            n = input.nextInt();
            if (m + n == 0) return;
            
            x1 = input.nextInt();
            y1 = input.nextInt();
            x2 = input.nextInt();
            y2 = input.nextInt();
            x3 = input.nextInt();
            y3 = input.nextInt();
            
            // get the stops
            int size = n * m;
            s1 = size / 4;
            s2 = size / 2;
            s3 = 3 * size / 4;
            s4 = size;
            steps = 0;
            
            // solve it
            grid = new int[m][n]; // 1 is default, 2 for curr, 3 for visited, - for station
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    grid[i][j] = 1;
            // set the stations
            grid[x1][y1] = -1;
            grid[x2][y2] = -1;
            grid[x3][y3] = -1;
            grid[0][1] = -1;
            
            // make the first move
            int routes = solve(0, 0, 1);
            
            // output
            System.out.printf("Case %d: %d\n", cases, routes);
            ++cases;
        }
    }
    
    public static int solve(int x, int y, int nextStation) {
    //System.out.println("solve " + x + " " + y);
        // successful route
        if (x == 0 && y == 1 && steps == s4)
            return 1;
            
        // check outside of grid
        if (x < 0 || x >= m || y < 0 || y >= n)
            return 0;

        // check not visited
        if (Math.abs(grid[x][y]) == 3)
            return 0;
            
        // check right time to station
        int st = stationTime(x, y, nextStation);
        if (grid[x][y] < 0 && st == 0)
            return 0;
            
        // check manhattan distance
        if (manhattan(x, y, nextStation))
            return 0;
            
        // mark the current move
        int sign = Math.abs(grid[x][y]) / grid[x][y];
        grid[x][y] = 2 * sign;
        ++steps;
        
        // check connectivity and access
        if (!connected() && !access())
            return 0;
    
        // mark visited
        sign = Math.abs(grid[x][y]) / grid[x][y];
        grid[x][y] = 3 * sign;
        
        // make another move
        int routes = solve(x + 1, y, st);
        routes += solve(x - 1, y, st);
        routes += solve(x, y + 1, st);
        routes += solve(x, y - 1, st);
        
        // unmark visited
        //sign = Math.abs(grid[x][y]) / grid[x][y];
        //grid[x][y] = 2 * sign;
        
        // unmark current
        sign = Math.abs(grid[x][y]) / grid[x][y];
        grid[x][y] = 1 * sign;
        --steps;
        
        return routes;
    
    }
    
    public static boolean manhattan(int x, int y, int nextStation) {
        switch (nextStation) {
            case 1:
                return (Math.abs(x - x1) + Math.abs(y - y1) > s1 - steps);
            case 2:
                return (Math.abs(x - x1) + Math.abs(y - y1) > s2 - steps);
            case 3:
                return (Math.abs(x - x1) + Math.abs(y - y1) > s3 - steps);
            default:
                return (Math.abs(x - x1) + Math.abs(y - y1) > s4 - steps);
        }
    }
    
    public static int stationTime(int x, int y, int nextStation) {
        switch (nextStation) {
            case 1:
                if (s1 == steps)
                    return 2;
                break;
            case 2:
                if (s2 == steps)
                    return 3;
                break;
            case 3:
                if (s3 == steps)
                    return 4;
                break;
            default:
                return 0;
        }
        return 0;
    }
    
    public static boolean connected() {
    
        // first non visited spot
        int x = -1;
        int y = -1;
        for (int i = 0; x == -1 && i < m; ++i) {
            for (int j = 0; y == -1 && j < n; ++j) {
                if (Math.abs(grid[i][j]) > 1) {
                    x = i;
                    y = j;
                }
            }
        }
        
        boolean[][] newGrid = new boolean[m][n];
        
        // connect it
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(x * 10 + y);
        int count = 1;
        newGrid[x][y] = true;
        while (!stack.empty()) {
            // add it's kids
            Integer s = stack.pop();
            ++count;
            x = s / 10;
            y = s % 10;
            if (!(x + 1 < 0 || x + 1 >= m || y < 0 || y >= n || Math.abs(grid[x + 1][y]) > 1 || newGrid[x + 1][y])) {
                stack.push((x + 1) * 10 + y);
                newGrid[x + 1][y] = true;
            }
            if (!(x - 1 < 0 || x - 1 >= m || y < 0 || y >= n || Math.abs(grid[x - 1][y]) > 1 || newGrid[x - 1][y])) {
                stack.push((x - 1) * 10 + y);
                newGrid[x - 1][y] = true;
            }
            if (!(x < 0 || x >= m || y + 1 < 0 || y + 1 >= n || Math.abs(grid[x][y + 1]) > 1 || newGrid[x][y + 1])) {
                stack.push(x * 10 + y + 1);
                newGrid[x][y + 1] = true;
            }
            if (!(x < 0 || x >= m || y - 1 < 0 || y - 1 >= n || Math.abs(grid[x][y - 1]) > 1 || newGrid[x][y - 1])) {
                stack.push(x * 10 + y - 1);
                newGrid[x][y - 1] = true;
            }
        }
        return count == s4 - steps;
    }
    
    public static boolean access() {
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int a = 0;
                if (i - 1 >= 0 && Math.abs(grid[i - 1][j]) < 3)
                    ++a;
                if (i + 1 < m && Math.abs(grid[i + 1][j]) < 3)
                    ++a;
                if (j + 1 < n && Math.abs(grid[i][j + 1]) < 3)
                    ++a;
                if (j - 1 >= 0 && Math.abs(grid[i][j - 1]) < 3)
                    ++a;
                if (i == 0 && j == 1 && a == 0)
                    return false;
                if (a < 2)
                    return false;
            }
        }
        return true;
    }
}
