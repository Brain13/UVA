// 10041 Vito's Family
import java.util.*;
public class Vito {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        
        for (int q = 0; q < cases; ++q) {
        
            int houses = input.nextInt();
            int[] addresses = new int[houses];
            
            for (int i = 0; i < houses; ++i) {
                addresses[i] = input.nextInt();
            }
            
            Arrays.sort(addresses);
        
            int median = (addresses[houses / 2] + addresses[(houses - 1) / 2]) / 2;
            int median2 = (addresses[houses / 2] + addresses[(houses - 1) / 2]) / 2 + 1;
            int distance = 0;
            int distance2 = 0;
            for (int i = 0; i < houses; ++i) {
                distance += Math.abs(addresses[i] - median);
                distance2 += Math.abs(addresses[i] - median2);
            }
            
            System.out.println(Math.min(distance, distance2));
        
        }
    }
}
