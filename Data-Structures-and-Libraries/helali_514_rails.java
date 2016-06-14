import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Rails {

	public static void main(String[] args) throws Exception {

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();

		String line;
		String[] joker;
		int count;
		int whichCoach;

		line = bfr.readLine();

		while (!line.equals("0")) {
			count = Integer.parseInt(line);
			line = bfr.readLine();
			while (!line.equals("0")) {
				joker = line.split(" ");
				if (joker.length != count) {
					System.out.println("No");
					break;
				}
				whichCoach = 0;
				for (int i = count; i > 0; i--) {
					a.push(i);
				}
				while (!a.isEmpty() && whichCoach < joker.length) {

					while (!b.isEmpty() && whichCoach < joker.length
							&& b.peek() == Integer.parseInt(joker[whichCoach])) {
						b.pop();
						whichCoach++;
//						 System.out.println("=================");
//						 System.out.print("|b => ");
//						 for (int i = b.size() - 1; i >= 0; i--) {
//						 System.out.print(b.get(i) + "| ");
//						 }
//						 System.out.println();
//						 System.out.print("|a => ");
//						 for (int i = a.size() - 1; i >= 0; i--) {
//						 System.out.print(a.get(i) + "| ");
//						 }
//						 System.out.println();
//						 System.out.print("|joker => ");
//						 for (int i = whichCoach; i < joker.length; i++) {
//						 System.out.print(joker[i] + "| ");
//						 }
//						 System.out.println();
//						 System.out.println("====================");
					}

					b.push(a.pop());
//					 System.out.println("=================");
//					 System.out.print("|b => ");
//					 for (int i = b.size() - 1; i >= 0; i--) {
//					 System.out.print(b.get(i) + "| ");
//					 }
//					 System.out.println();
//					 System.out.print("|a => ");
//					 for (int i = a.size() - 1; i >= 0; i--) {
//					 System.out.print(a.get(i) + "| ");
//					 }
//					 System.out.println();
//					 System.out.print("|joker => ");
//					 for (int i = whichCoach; i < joker.length; i++) {
//					 System.out.print(joker[i] + "| ");
//					 }
//					 System.out.println();
//					 System.out.println("====================");

				}
				while (!b.isEmpty() && whichCoach < joker.length) {
					if (b.peek() == Integer.parseInt(joker[whichCoach])) {
						b.pop();
						whichCoach++;
//						 System.out.println("=================");
//						 System.out.print("|b => ");
//						 for (int i = b.size() - 1; i >= 0; i--) {
//						 System.out.print(b.get(i) + "| ");
//						 }
//						 System.out.println();
//						 System.out.print("|a => ");
//						 for (int i = a.size() - 1; i >= 0; i--) {
//						 System.out.print(a.get(i) + "| ");
//						 }
//						 System.out.println();
//						 System.out.print("|joker => ");
//						 for (int i = whichCoach; i < joker.length; i++) {
//						 System.out.print(joker[i] + "| ");
//						 }
//						 System.out.println();
//						 System.out.println("====================");
						continue;
					}
					break;
				}
				if (a.isEmpty() && whichCoach == joker.length) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
				line = bfr.readLine();
				a.clear();
				b.clear();
			}
			System.out.println();
			a.clear();
			b.clear();
			line = bfr.readLine();
		}
	}

}
