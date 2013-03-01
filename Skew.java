// 575 Skew Binary
import java.util.*;
public class Skew {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (true) {

			String num = input.next();
			if (num.equals("0")) return;
			int answer = 0;
			int pow = 2;
			for (int i = num.length() - 1; i >= 0; --i) {
				answer += (num.charAt(i) - '0') * (pow - 1);
				pow *= 2;
			}
			System.out.println(answer);
		}
	}
}

