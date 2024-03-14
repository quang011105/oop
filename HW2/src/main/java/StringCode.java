import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {
	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 *
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		if (str.length() == 0)
			return 0;
		int smax = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			int dem = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					dem++;
				} else {
					break;
				}
				smax = Math.max(smax, dem);
			}
		}
		return smax;
	}

	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 *
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String s = "";
		if (str.length() == 0)
			return str;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9) {
				s += str.charAt(i);
			} else {
				int n = str.charAt(i) - '0';
				for (int j = 0; j < n; j++) {
					s += str.charAt(i + 1);
				}
			}
		}
		if (str.charAt(str.length() - 1) - '0' < 0 || str.charAt(str.length() - 1) - '0' > 9) {
			s += str.charAt(str.length() - 1);
		}
		return s;
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i <= a.length() - len; i++) {
			set.add(a.substring(i, i + len));
		}
		for (int i = 0; i <= b.length() - len; i++) {
			if (set.contains(b.substring(i, i + len))) {
				return true;
			}
		}
		return false;
	}
}