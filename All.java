// 10340 All in All
import java.util.*;
public class All {
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        while (input.hasNext()) {
        
            String s = input.next();
            String t = input.next();
            
            int is = 0;
            int it = 0;
            
            while (is < s.length() && it < t.length()) {
                if (s.charAt(is) == t.charAt(it))
                    ++is;
                ++it;
            }
            
            if (it <= t.length() && is == s.length())
                System.out.println("Yes");
            else
                System.out.println("No");
        
        }
    }
}
