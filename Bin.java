// 102 Ecological Bin Packing
import java.util.*;
public class Bin {
	public static void main(String[] args) {

		Scanner input = new Scanner (System.in);
		while (input.hasNext()) {

/*
bcg
bgc
cbg
cgb
gbc
gcb
*/

			// input
			int b1 = input.nextInt();
			int g1 = input.nextInt();
			int c1 = input.nextInt();
			int b2 = input.nextInt();
			int g2 = input.nextInt();
			int c2 = input.nextInt();
			int b3 = input.nextInt();
			int g3 = input.nextInt();
			int c3 = input.nextInt();

			// solve
			int[] moves = new int[6];;
			moves[0] = b2 + b3 + c1 + c3 + g1 + g2;
			int min = 0;
			moves[1] = b2 + b3 + g1 + g3 + c1 + c2;
			if (moves[1] < moves[min])
				min = 1;
			moves[2] = c2 + c3 + b1 + b3 + g1 + g2;
			if (moves[2] < moves[min])
				min = 2;
			moves[3] = c2 + c3 + g1 + g3 + b1 + b2;
			if (moves[3] < moves[min])
				min = 3;
			moves[4] = g2 + g3 + b1 + b3 + c1 + c2;
			if (moves[4] < moves[min])
				min = 4;
			moves[5] = g2 + g3 + c1 + c3 + b1 + b2;
			if (moves[5] < moves[min])
				min = 5;

			// output
			switch (min) {
				case 0:
					System.out.println("BCG " + moves[0]);
					break;
				case 1:
					System.out.println("BGC " + moves[1]);
					break;
				case 2:
					System.out.println("CBG " + moves[2]);
					break;
				case 3:
					System.out.println("CGB " + moves[3]);
					break;
				case 4:
					System.out.println("GBC " + moves[4]);
					break;
				case 5:
					System.out.println("GCB " + moves[5]);
					break;
			}
		}
	}
}

