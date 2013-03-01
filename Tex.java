// 272 TEX Quotes
import java.util.*;
public class Tex {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean left = true;
		while (input.hasNext()) {
			String line = input.nextLine();
			for (int i = 0; i < line.length(); ++i) {
				char c = line.charAt(i);
				if (c == '\"') {
					if (left) {
						System.out.print("``");
						left = false;
					}
					else {
						System.out.print("\'\'");
						left = true;
					}
				}
				else
					System.out.print(c);
			}
			System.out.println();
		}
	}
}

