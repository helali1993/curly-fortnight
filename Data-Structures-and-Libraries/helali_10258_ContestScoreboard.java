import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));

		List<Entry> entries = new ArrayList<Entry>(0);
		List<Output> outputs = new ArrayList<Output>(0);
		ArrayList<Integer> contestor = new ArrayList<Integer>(0);
		HashMap<Integer, Integer> solved = new HashMap<Integer, Integer>(0);

		String line;
		int cases, count, start, corrects, penalty;
		String stat;
		String[] joker;
		Entry e;
		Output o;

		line = bfr.readLine();
		cases = Integer.parseInt(line);

		bfr.readLine();

		while (cases > 0) {

			line = bfr.readLine();
			while (line != null && !(line.equals(""))) {
				joker = line.split(" ");
				e = new Entry();
				e.create(joker[0], joker[1], joker[2], joker[3]);
				entries.add(e);
				contestor.add(Integer.parseInt(joker[0]));
				line = bfr.readLine();
			}

			Collections.sort(entries);
			count = entries.get(entries.size() - 1).cont;
			start = 1;

			while (start <= count) {

				corrects = 0;
				penalty = 0;

				for (int i = 0; i < entries.size(); i++) {
					if (entries.get(i).cont == start
							&& entries.get(i).status.equals("C")
							&& !solved.containsKey(entries.get(i).problem)) {
						corrects++;
						penalty += entries.get(i).time;
						solved.put(entries.get(i).problem, entries.get(i).time);
					}
				}

				for (Integer i : solved.keySet()) {
					for (int j = 0; j < entries.size(); j++) {
						if (entries.get(j).cont == start
								&& entries.get(j).status.equals("I")
								&& entries.get(j).problem == i
								&& entries.get(j).time <= solved.get(i)) {
							penalty += 20;
						}
					}
				}
				if (contestor.contains(start)) {
					o = new Output();
					o.contestant = start;
					o.correct_answers = corrects;
					o.penalty = penalty;
					outputs.add(o);
				}
				start++;
				solved.clear();
			}
			Collections.sort(outputs);
			for (int i = 0; i < outputs.size(); i++) {
				System.out.println(outputs.get(i).contestant + " "
						+ outputs.get(i).correct_answers + " "
						+ outputs.get(i).penalty);
			}
			outputs.clear();
			entries.clear();
			solved.clear();
			contestor.clear();
			cases--;
			if (cases != 0) {
				System.out.println();
			}
		}
	}
}

class Entry implements Comparable {

	int cont;
	int problem;
	int time;
	String status;

	void create(String c, String p, String t, String s) {
		cont = Integer.parseInt(c);
		problem = Integer.parseInt(p);
		time = Integer.parseInt(t);
		status = s;
	}

	public int compareTo(Entry a, Entry b) {
		// TODO Auto-generated method stub
		if (a.cont < b.cont || (a.cont == b.cont && a.time < b.time)
				|| (a.time == b.time && a.problem < b.problem))
			return -1;

		if (a.cont == b.cont && a.time == b.time && a.problem == b.problem)
			return 0;

		return 1;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return compareTo(this, (Entry) arg0);
	}
}

class Output implements Comparable<Output> {

	int contestant;
	int correct_answers;
	int penalty;

	@Override
	public int compareTo(Output o) {

		if (correct_answers > o.correct_answers
				|| (correct_answers == o.correct_answers && penalty < o.penalty)
				|| (correct_answers == o.correct_answers
						&& penalty == o.penalty && contestant < o.contestant)) {
			return -1;
		}

		if (correct_answers == o.correct_answers && contestant == o.contestant
				&& penalty == o.penalty) {
			return 0;
		}

		return 1;
	}
}
