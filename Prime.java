// 10924 Prime Words
import java.util.*;
public class Prime {
    public static void main(String[] args) {
    
        // create a list of primes
        boolean[] primes = new boolean[20 * 52 + 1];
        // start with everything true for sieve
        for (int i = 0; i < primes.length; ++i)
            primes[i] = true;

        // figure out which ones should be false;
        for (int i = 2; i < primes.length / 2 + 1; ++i) {
            if (primes[i]) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
    
        // solve the problem
        Scanner input = new Scanner(System.in);
        
        while (input.hasNext()) {
        
            String text = input.nextLine();
            int sum = 0;
            for (int i = 0; i < text.length(); ++i) {
                char c = text.charAt(i);
                // A < a
                if (c >= 'a') {
                    sum += c - 'a' + 1;
                }
                else {
                    sum += c - 'A' + 27;
                }
            }
        
            System.out.println("It is" + (primes[sum] ? " " : " not " ) + "a prime word.");
        
        }
    
    }
}
