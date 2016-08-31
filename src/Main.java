import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static long[] read(String file, int n) throws IOException {
		long[] res = new long[n];
		int i = 0;
		BufferedReader in = new BufferedReader(new FileReader(file));
		while (in.ready()) {
			String s = in.readLine();
			// if (s == null)
			// break;
			res[i] = Long.parseLong(s);
			i++;
		}
		in.close();
		return res;
	}

	static int h(long k, int p) {
		return (int) ((k + 100000000000L) % (long) p);
	}

	public static void main(String[] args) throws IOException {
		// int n = 100000;
		// int p = 26003;
		int n = 1000000;
		int p = 999371;
		//long[] ints = read("C:/Users/Lucky/Desktop/Prometheus/8. Hash tables/test_06.txt/test_06.txt", n);
		long[] ints = read("C:/Users/Lucky/Desktop/Prometheus/8. Hash tables/input_06.txt/input_06.txt", n);
		@SuppressWarnings("unchecked")
		LinkedList<Long>[] ll = (LinkedList<Long>[]) new LinkedList<?>[p];
		for (int i = 0; i < ll.length; i++) {
			ll[i] = new LinkedList<Long>();
		}
		for (int i = 0; i < ints.length; i++) {
			ll[h(ints[i], p)].add(ints[i]);
		}
		List<Integer> found = new LinkedList<Integer>();
		outer: for (int s = -1000; s <= 1000; s++)
			for (int i = 0; i < n; i++) {
				long searched = (long) s - ints[i];
				if (ll[h(searched, p)].contains(searched)) {
					found.add(s);
					continue outer;
				}
			}
		System.out.println(found.size());
	}
}