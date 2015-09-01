package substring;

public class Utilities {

	/**
	 * Search an array using Knuth-Morris-Pratt algorithm.
	 *
	 * @param array The array to search.
	 * @param pattern The search pattern.
	 * @return the index of the pattern or -1 if it is not present.
	 */
	public static int subStringIndex(int[] array, int[] pattern) {
		if (array == null || pattern == null)	{
			throw new IllegalArgumentException("Neither array nor pattern can be null");
		}
		if (array.length == 0 || pattern.length == 0) {
			throw new IllegalArgumentException("Neither array nor pattern canbe empty");
		}
		if (pattern.length > array.length) {
			throw new IllegalArgumentException("Array must be larger than pattern");
		}

		int[] prefixArray = prefixArray(pattern);
		int index = -1;

		for (int m = 0, s = 0; m < array.length; m++) {
			if (pattern[s] == array[m]) {
				s++;
			}
			else {
				if (s != 0) {
					s = prefixArray[s - 1];
					m--;
				}
			}
			if (s == pattern.length) {
				index = m - pattern.length + 1;
				break;
			}
		}

		return index;
	}

	private static int[] prefixArray(int[] pattern) {
		int[] array = new int[pattern.length];
		array[0] = 0;

		for (int i = 1, j = 0; i < array.length; i++) {
			while (pattern[i] != pattern[j]) {
				if (j == 0) {
					break;
				}
				j = array[j - 1];
			}

			if (pattern[i] == pattern[j]) {
				array[i] = j + 1;
				j++;
			}
			else {
				array[i] = j;
			}

		}
		return array;
	}
}
