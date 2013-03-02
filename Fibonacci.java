// 10579 Fibonacci Numbers
import java.util.*;
import java.math.BigInteger;
public class Fibonacci {
    public static void main(String[] args) {
    
        // list of fibonnaci numbers calculated so far
        ArrayList<BigInteger> fibs = new ArrayList<BigInteger>();
        
        // want a one based array, first two values are one
        fibs.add(BigInteger.ZERO);
        fibs.add(BigInteger.ONE);
        fibs.add(BigInteger.ONE);
    
        Scanner input = new Scanner(System.in);
        
        while (input.hasNext()) {
        
            int in = input.nextInt();
            
            // answer exists
            if (in < fibs.size()) {
                System.out.println(fibs.get(in));
            }
            // have to get the answer
            else {
                while (fibs.size() <= in) {
                    fibs.add(fibs.get(fibs.size() - 1).add(fibs.get(fibs.size() - 2)));
                }
                // now output the answer
                System.out.println(fibs.get(in));
            }
        
        }
    }
}
