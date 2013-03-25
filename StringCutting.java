// 1215 String Cutting
import java.util.*;
public class StringCutting {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int q = 0; q < cases; ++q) {
		
			int num = input.nextInt();
			int[] cuts = new int[num];
			for (int i = 0; i < num; ++i)
				cuts[i] = input.nextInt();
				
			String text = input.next();
			ArrayList<String> strings = new ArrayList<String>();
            strings.add(text);
            int totalCut = 0;
            // make a cut
			for (int i = 0; i < num; ++i) {
                int index = -1;
                int total = 0;
                
                // find the cut
                for (int j = 0; j < strings.size(); ++j) {
                    if (cuts[i] < total + strings.get(j).length()) {
                        index = j;
                        break;
                    }
                    total += strings.get(j).length();
                }
                
                String cur = strings.get(index);
                String s1 = cur.substring(0, cuts[i] - total);
                String s2 = cur.substring(cuts[i] - total);

                boolean[] alpha1 = new boolean[26];
                boolean[] alpha2 = new boolean[26];
                for (int j = 0; j < s1.length(); ++j) {
                    alpha1[s1.charAt(j) - 'a'] = true;
                }
                for (int j = 0; j < s2.length(); ++j) {
                    alpha2[s2.charAt(j) - 'a'] = true;
                }
                for (int j = 0; j < 26; ++j) {
                    if ((alpha1[j] && !alpha2[j]) || (!alpha1[j] && alpha2[j])) {
                        ++totalCut;
                    }
                }
                
                // put the string back
                strings.set(index, s1);
                strings.add(index + 1, s2);
			}
            
            System.out.println(totalCut);
		}
	}
}
