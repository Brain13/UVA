// 11875 Brick Game
import java.util.*;
public class Brick {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int cases = input.nextInt();
        for (int q = 1; q <= cases; ++q) {
        
            int size = input.nextInt();
            for (int i = 0; i < size; ++i) {
                int j = input.nextInt();
                if (i == (size - 1) / 2)
                    System.out.println("Case " + q + ": " + j);
            }
        
        }
    }
}
