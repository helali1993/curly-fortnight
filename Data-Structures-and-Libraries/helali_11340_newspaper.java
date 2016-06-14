/* if we used float in this problem,
* we get a wrong answer verdict
* use double instead
* I have solved the problem with hashmap although it stated that
* the problem is an 1D arry Maniupulation, don't know it that is an 
* over kill or not
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Newspaper {

	public static void main(String[] args) throws Exception {

		 BufferedReader bfr = new BufferedReader(
		 new InputStreamReader(System.in));

//		BufferedReader bfr = new BufferedReader(new FileReader("input.txt"));

		String line;
		line = bfr.readLine();

		int cases = Integer.parseInt(line);
		int inputs, cents;
		int numOfLines;
		double sum = 0;
		int occ;
		String[] joker;

		HashMap<String,Double> costs = new HashMap<String, Double>(0);

		while (cases > 0) {
			line = bfr.readLine();
			inputs = Integer.parseInt(line);
			while (inputs > 0) {
				line = bfr.readLine();
				joker = line.split(" ");
				cents = Integer.parseInt(joker[1]);
				costs.put(joker[0], (double) (cents / 100.0));
				inputs--;
			}
			line = bfr.readLine();
			numOfLines = Integer.parseInt(line);
			while (numOfLines > 0) {
				line = bfr.readLine();
				for (String s : costs.keySet()) {
					if (line.contains(s)) {
						occ = countChar(line, s);
						sum += occ * costs.get(s);
					}
				}
				numOfLines--;
			}
			sum = round(sum, 2);
			System.out.printf("%.2f$\n", sum);
			;
			sum = 0;
			costs.clear();
			cases--;
		}
	}

	static int countChar(String s, String c) {

		char ch = c.charAt(0);
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ch) {
				counter++;
			}
		}
		return counter;
	}

	static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
