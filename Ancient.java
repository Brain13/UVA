// 10451 Ancient Village Sports
import java.util.*;
public class Ancient {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		int cases = 1;
		
		while (true) {
		
			int n = input.nextInt();
			if (n < 3) return;
			double A = input.nextDouble();
			
			double angle = Math.PI * (n - 2) / (2 * n);
			double s = Math.sqrt(4 * A / (n * Math.tan(angle)));
			double ri = 2 * A / (n * s);
			double ro = s / (2 * Math.cos(angle));
			
			double ai = Math.PI * ri * ri;
			double ao = Math.PI * ro * ro;
			
			double off = A - ai;
			double spec = ao - A;
			
			System.out.printf("Case %d: %.5f %.5f\n", cases, spec, off);
			++cases;
		}
	}
}