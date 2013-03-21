// 1197 The Suspects
import java.util.*;
public class Suspects {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		while (true) {
		
			int n = input.nextInt();
			int m = input.nextInt();
			if (n + m == 0) return;
			
			Student[] st = new Student[n];
			Group[] gp = new Group[m];
			
			// read in data
			for (int i = 0; i < m; ++i) {
				gp[i] = new Group();
				gp[i].students = new ArrayList<Integer>();
				int members = input.nextInt();
				for (int j = 0; j < members; ++j) {
					int id = input.nextInt();
					if (st[id] == null) {
						st[id] = new Student();
						st[id].groups = new ArrayList<Integer>();
					}
					st[id].groups.add(i);
					gp[i].students.add(id);
				}
			}
            
			// find suspects
			Stack<Group> stack = new Stack<Group>();
			Student initial = st[0];
            // if 0 is not in a group, then there are no other suspects
            if (initial == null) {
                System.out.println(1);
            }
            else {
                initial.suspect = true;
                for (int i = 0; i < initial.groups.size(); ++i) {
                    int gid = initial.groups.get(i);
                    stack.push(gp[gid]);
                    gp[gid].tracked = true;
                }
                while (!stack.empty()) {
                    Group g = stack.pop();
                    for (int i = 0; i < g.students.size(); ++i) {
                        int sid = g.students.get(i);
                        st[sid].suspect = true;
                        for (int j = 0; j < st[sid].groups.size(); ++j) {
                            int gid = st[sid].groups.get(j);
                            if (!gp[gid].tracked) {
                                stack.push(gp[gid]);
                                gp[gid].tracked = true;
                            }
                        }
                    }
                }
                
                // output suspects
                int sus = 0;
                for (int i = 0; i < n; ++i) {
                    if (st[i] != null && st[i].suspect)
                        ++sus;
                }
                System.out.println(sus);
            }
		}
	}
	
	private static class Student {
		public ArrayList<Integer> groups;
		public boolean suspect;
	}
	
	private static class Group {
		public ArrayList<Integer> students;
		public boolean tracked;
	}
}
