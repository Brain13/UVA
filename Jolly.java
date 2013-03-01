// 10038 Jolly Jumpers
import java.util.*;
public class Jolly {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {


			int num = input.nextInt();
			if (num == 1) {
				System.out.println("Jolly");
				continue;
			}

			boolean[] isJolly = new boolean[num];
			boolean jolly = true;
			int left = input.nextInt();
			int right = input.nextInt();
			int diff = Math.abs(left - right);
			if (diff < num && diff != 0)
				isJolly[diff] = true;
			left = right;
			for (int i = 2; i < num; ++i) {
				right = input.nextInt();
				diff = Math.abs(left - right);
				if (diff < num && diff != 0 && !isJolly[diff])
					isJolly[diff] = true;
				else {
					jolly = false;
					break;
				}
				left = right;
			}
			if (jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
			input.nextLine();
		}
	}
}

