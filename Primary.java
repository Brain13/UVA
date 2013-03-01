// 10035 Primary Arithmetic
import java.util.*;
public class Primary {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (true) {

			String a = input.next();
			String b = input.next();
			input.nextLine();
			if (a.equals("0") && b.equals("0")) return;
//System.out.println("check");
			while (b.length() < a.length())
				b = "0" + b;
			while (a.length() < b.length())
				a = "0" + a;
//System.out.println("same");
			boolean carry = false;
			int numCarry = 0;
			for (int i = a.length() - 1; i >= 0; --i) {
				int sum = a.charAt(i) + b.charAt(i) - '0' - '0';
//System.out.println(sum);
				if ((carry && sum + 1 >= 10) || (!carry && sum >= 10)) {
					++numCarry;
					carry = true;
				}
				else
					carry = false;
			}

			if (numCarry == 0)
				System.out.println("No carry operation.");
			else if (numCarry == 1)
				System.out.println("1 carry operation");
			else
				System.out.println(numCarry + " carry operations.");
		}
	}
}

