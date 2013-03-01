// 119 Greedy Gift Givers
import java.util.*;
public class Greedy {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean first = true;

		while (input.hasNext()) {

			// extra line between input cases
			if (!first) System.out.println();
			first = false;

			int numPpl = input.nextInt();
			// store the people in order
			HashMap<String, Integer> ppl = new HashMap<String, Integer>();
			String[] order = new String[numPpl];
			for (int i = 0; i < numPpl; ++i) {
				String name = input.next();
				ppl.put(name, 0);
				order[i] = name;
			}

			// update their money
			for (int i = 0; i < numPpl; ++i) {

				String name = input.next();
				int start = input.nextInt();

				// normalize profit
				ppl.put(name, ppl.get(name) - start);

				int friends = input.nextInt();
				if (friends != 0) {
					int gift = start / friends;
					// consider extra money not given to friends
					int extra = start % friends;
					ppl.put(name, ppl.get(name) + extra);

					// give gifts
					for (int j = 0; j < friends; ++j) {
						String fname = input.next();
						ppl.put(fname, ppl.get(fname) + gift);
					}
				}
				else
					ppl.put(name, ppl.get(name) + start);
			}

			// give the answer
			for (int i = 0; i < numPpl; ++i) {
				String name = order[i];
				int money = ppl.get(name);
				System.out.println(name + " " + money);
			}
		}
	}
}
