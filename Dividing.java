// 562 Dividing Coins
import java.util.*;
public class Dividing {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int q = 0; q < cases; ++q) {

			int numcoins = input.nextInt();
			int[] coins = new int[numcoins];
			for (int i = 0; i < numcoins; ++i) {
				coins[i] = input.nextInt();
			}

			Arrays.sort(coins);
			int a = 0;
			int b = 0;
			for (int i = numcoins - 1; i >= 0; --i) {
				if (a > b)
					b += coins[i];
				else
					a += coins[i];
			}

			System.out.println(Math.abs(b - a));

		}
	}
}
