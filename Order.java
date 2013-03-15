// 10305 Ordering Tasks
import java.util.*;
public class Order {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		while (true) {
		
			int n = input.nextInt();
			int m = input.nextInt();
			if (n + m == 0) return;
			
			boolean[] used = new boolean[n + 1];
			Tasks[] tasks = new Tasks[n + 1];
			int[] order = new int[n];
			int orderPos = 0;
			for (int i = 1; i <= n; ++i) {
				tasks[i] = new Tasks();
				tasks[i].reqs = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < m; ++i) {
				int left = input.nextInt();
				int right = input.nextInt();
				tasks[right].reqs.add(left);
			}
            
            Stack<Tasks> stack = new Stack<Tasks>();
		
			for (int i = 1; i <= n; ++i) {
				if (!used[i]) {
                    stack.push(tasks[i]);
                    while (!stack.empty()) {
                        Tasks curr = stack.pop();
                        boolean allClear = true;
                        for (int j = 0; j < curr.reqs.size(); ++j) {
                            if (!used[curr.reqs.get(j)]) {
                                stack.push(tasks[curr.reqs.get(j)]);
                                allClear = false;
                            }
                        }
                        if (!allClear)
                            stack.push(curr);
                    }
					//resolve(tasks, i, used, order, orderPos);
					used[i] = true;
					order[orderPos] = i;
					++orderPos;
				}
			}
			
			for (int i = 0; i < n; ++i) {
				if (i == 0)
					System.out.print(order[i]);
				else
					System.out.print(" " + order[i]);
			}
			System.out.println();
		
		}
	}
	
	public static void resolve(Tasks[] tasks, int currentTask, boolean[] used, int[] order, int orderPos) {
		for (int i = 0; i < tasks[currentTask].reqs.size(); ++i) {
			if (!used[tasks[currentTask].reqs.get(i)]) {
				resolve(tasks, i, used, order, orderPos);
				used[i] = true;
				order[orderPos] = tasks[currentTask].reqs.get(i);
				++orderPos;
			}
		}
	}
	
	private static class Tasks {
		public ArrayList<Integer> reqs;
	}
}