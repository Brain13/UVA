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
            
            int dx = x1 - x2;
            int dy = y1 - y2;
			
			// no moves needed (same spot)
			if (dx == 0 && dy == 0) {
				System.out.println(0);
			}
			// same column, row, diagonal, 1 move
			else if (dx == 0 || dy == 0 || Math.abs(dx) == Math.abs(dy)) {
				System.out.println(1);
			}
			// max of two moves ever
			else {
				System.out.println(2);
			}
		}
	}
}
