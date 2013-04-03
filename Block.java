// 435 Block Voting
import java.util.*;
public class Block {
    public static void main(String[] args) {
    
        int[] pow2 = new int[21];
        pow2[0] = 1;
        for (int i = 1; i < 21; ++i) {
            pow2[i] = pow2[i - 1] * 2;
        }
    
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int q = 0; q < cases; ++q) {
        
            int parties = input.nextInt();
            int[] power = new int[parties];
            int[] index = new int[parties];
            // list of combos
            ArrayList[] combo = new ArrayList[parties];
            for (int i = 0; i < parties; ++i)
                combo[i] = new ArrayList<Combo>();
            
            int total = 0;
            for (int i = 0; i < parties; ++i) {
                power[i] = input.nextInt();
                total += power[i];
            }
            int minimum = total / 2 + 1;

            // generate all combos
            // first put in the singles
            for (int i = 0; i < parties; ++i) {
                Combo c = new Combo();
                c.party = new boolean[parties];
                c.party[i] = true;
                c.power = power[i];
                combo[0].add(c);
            }
            // get the other combos
            for (int i = 1; i < parties; ++i) {
                // pair from first row....
                for (int j = 0; j < parties; ++j) {
                    // ...and the previous level
                    for (int k = 0; k < combo[i - 1].size(); ++k) {
                        Combo c = new Combo();
                        Combo single = (Combo) combo[0].get(j);
                        Combo set = (Combo) combo[i - 1].get(k);
                        
                        // check that the single and set aren't duplicates
                        c.party = new boolean[parties];
                        boolean dup = false;
                        for (int m = 0; m < parties; ++m) {
                            if (single.party[m] && set.party[m]) {
                                dup = true;
                                break;
                            }
                            else {
                                c.party[m] = single.party[m] || set.party[m];
                            }
                        }
                        if (dup)
                            break;
                        
                        // get the current power
                        c.power = single.power + set.power;
                        
                        // add into combos
                        combo[i].add(c);
                        
                    }
                }
            }
            
            // calculate the power index
            for (int k = 0; k < parties; ++k) {
            for (int i = 1; i < parties; ++i) {
                for (int j = 0; j < combo[i].size(); ++j) {
                    Combo set = (Combo) combo[i].get(j);
                    if (set.party[k] && set.power >= minimum && set.power - power[k] < minimum)
                        ++index[k];
                     else {
                        //System.out.println("not good. set: " + set.power + ", single: " + power[k]);
                     }
                    /*for (int x = 0; x < parties; ++x)
                        if (set.party[x])
                            System.out.print((char) (x + 'A'));
                    System.out.println(" " + set.power + " i: " + i + " j: " + j);*/
                }
            }
            }
            
            // find power index
            /*boolean[] used = new boolean[parties];
            for (int i = 0; i < parties; ++i) {
                used[i] = true;
                index[i] = solve(power, minimum, used, power[i]);
                used[i] = false;
            }*/
            
            
            for (int i = 0; i < parties; ++i) {
                System.out.println("party " + (i + 1) + " has power index " + index[i]);
            }
            System.out.println();
        
        }
    }
    
    private static class Combo {
        public boolean[] party;
        public int power;
    }
    
    public static int solve(int[] power, int minimum, boolean[] used, int total) {
        if (total >= minimum)
            return 1;
        int sum = 0;
        for (int i = 0; i < power.length; ++i)
            sum += solve(power, minimum, used, power[i] + total);
        return sum;
    }
}
