// 11494 Queen
import java.util.*;
public class Queen {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		while (true) {
		
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			
			if (x1 + x2 + y1 + y2 == 0) return;
			
			// no moves needed (same spot)
			if (x1 == x2 && y1 == y2) {
				System.out.println(0);
			}
			// same column, row, 1 move
			else if (x1 == x2 || y1 == y2) {
				System.out.println(1);
			}
			// diagonal is harder
			else {
				boolean diag = false;
				// up left diag
				int i = x1;
				int j = y1;
				while (!diag && i >= 1 && j >= 1) {
					if (i == x2 && j == y2) {
						diag = true;
					}
					--i;
					--j;
				}
				// up right diag
				i = x1;
				j = y1;
				while (!diag && i >= 1 && j <= 8) {
					if (i == x2 && j == y2) {
						diag = true;
					}
					--i;
					++j;
				}
				// down left diag
				i = x1;
				j = y1;
				while (!diag && i <= 8 && j >= 1) {
					if (i == x2 && j == y2) {
						diag = true;
					}
					++i;
					--j;
				}
				// down right diag
				i = x1;
				j = y1;
				while (!diag && i <= 8 && j <= 8) {
					if (i == x2 && j == y2) {
						diag = true;
					}
					++i;
					++j;
				}
				
				// 1 move on diag
				if (diag) {
					System.out.println(1);
				}
				// max of two moves ever
				else {
					System.out.println(2);
				}
			}
		}
	}
}
