// 435 Block Voting
import java.util.*;
public class Block2 {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        int[] pow2 = new int[21];
        pow2[0] = 1;
        for (int i = 1; i < 21; ++i) {
            pow2[i] = pow2[i - 1] * 2;
        }
        
        int cases = input.nextInt();
        
        for (int q = 0; q < cases; ++q) {
        
            int parties = input.nextInt();
            
            int[] combos = new int[pow2[parties]];
            int[] bins = new int[parties];
            int[] powers = new int[parties];
            int[] index = new int[parties];
            for (int i = 0; i < parties; ++i) {
                bins[i] = 1 << i;
            }
            int total = 0;
            for (int i = 0; i < parties; ++i) {
                powers[i] = input.nextInt();
                total += powers[i];
            }
            int min = (total + 1) / 2;
            for (int i = 0; i < pow2[parties]; ++i) {
                for (int j = 0; j < parties; ++j) {
                    if ((i & bins[j]) != 0)
                        combos[i] += powers[j];
                }
            }
            
            for (int i = 0; i < pow2[parties]; ++i) {
                for (int j = 0; j < parties; ++j) {
                    if ((i & bins[j]) != 0 && combos[i] >= min && combos[i] - powers[j] < min)
                        ++index[j];
                }
            }
            
            for (int i = 0; i < parties; ++i) {
                System.out.printf("party %d has power index %d\n", (i + 1), index[i]);
            }
            System.out.print("\n");
        
        }
    }
}
