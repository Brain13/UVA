// 156 Ananagrams
import java.util.*;
public class Ananagrams {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ArrayList<String> words = new ArrayList<String>();
		while (true) {

			String line = input.nextLine();
			if (line.equals("#")) break;

			String[] split = line.split(" ");
			for (int i = 0; i < split.length; ++i)
				if (!split[i].equals(""))
					words.add(split[i]);

		}
//for (int i = 0; i < words.size(); ++i) System.out.println(words.get(i));
		ArrayList<String> ans = new ArrayList<String>();
		boolean[] used = new boolean[words.size()];
		for (int i = 0; i < used.length; ++i) {
			if (!used[i]) {
				for (int j = i + 1; j < used.length; ++j) {
					if (!used[j]) {
						if (compare(words.get(i), words.get(j))) {
							used[i] = true;
							used[j] = true;
						}
					}
				}
				if (!used[i])
					ans.add(words.get(i));
			}
		}

		Collections.sort(ans);
		for (int i = 0; i < ans.size(); ++i)
			System.out.println(ans.get(i));

	}

	public static boolean compare(String s, String t) {

		if (s.length() != t.length()) return false;
		char[] c = s.toUpperCase().toCharArray();
		char[] d = t.toUpperCase().toCharArray();
		Arrays.sort(c);
		Arrays.sort(d);
		for (int i = 0; i < c.length; ++i)
			if (c[i] != d[i])
				return false;
//		System.out.println(s + " matches " + t);
		return true;

	}
}
