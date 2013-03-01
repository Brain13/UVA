// 10018 Reverse and Add
import java.util.*;
public class Reverse {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);

        int cases = input.nextInt();
        
        for (int q = 0; q < cases; ++q) {
        
                long p = input.nextInt();
                int flips = 0;
                while (!isPalindrome(p)) {
                    long r = reverse(p);
                    p += r;
                    ++flips;
                }
                System.out.println(flips + " " + p);
        }
    }
    
    public static long reverse(long n) {
    
        String s = Long.toString(n);
        StringBuilder t = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; --i)
            t.append(s.charAt(i));
        return Long.parseLong(t.toString());
    
    }
    
    public static boolean isPalindrome(long n) {
    
        String s = Long.toString(n);
        for (int i = 0; i < s.length() / 2 + 1; ++i)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
       return true;
    
    }
}
