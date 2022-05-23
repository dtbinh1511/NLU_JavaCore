package Set_T.Du;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// Returns a set of WordCount objects represents the number of times each
	// unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public static Set<WordCount> getWordCounts(List<String> words) {
		Set<WordCount> res = new HashSet<WordCount>();
		for (String w : words) {
			WordCount wc = new WordCount(w, count(w, words));
			res.add(wc);
		}
		return res;
	}

	public static int count(String w, List<String> words) {
		int count = 0;
		for (String string : words) {
			if (string.equals(w))
				count++;
		}
		return count;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	// ex: Lam-2, Nong-2, Dai-1, Hoc-1 => res = dai hoc nong lam (not consider the
	// order of tokens)
	public static Set<String> getUniqueWords(List<String> words) {
		Set<String> res = new HashSet<String>();
		for (String w : words) {
			res.add(w);
		}
		return res;
	}

	// Returns the words that their appearances are 1, do not consider duplidated
	// words
	// ex: Lam-2, Nong-2, Dai-1, Hoc-1 => res = dai, hoc
	public static Set<String> getDistinctWords(List<String> words) {
		Set<String> res = new HashSet<String>();
		for (String w : words) {
			if (count(w, words) == 1)
				res.add(w);
		}
		return res;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public static Set<WordCount> exportWordCounts(List<String> words) {
		Set<WordCount> res = new TreeSet<WordCount>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		res.addAll(getWordCounts(words));
		return res;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public static Set<WordCount> exportWordCountsOrderByOccurence(List<String> words) {
		Set<WordCount> res = new TreeSet<WordCount>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o1.getWord().compareTo(o2.getWord()) > 0)
					return o1.getWord().compareTo(o2.getWord());
				return o2.getCount() - o1.getCount();
			}
		});
		res.addAll(getWordCounts(words));
		return res;
	}

	// delete words begining with the given pattern (i.e., delete words begin
	// with 'A' letter
	public static Set<WordCount> filterWords(Set<WordCount> words, String pattern) {
		Iterator<WordCount> iter = words.iterator();
		while (iter.hasNext()) {
			WordCount next = iter.next();
			if (next.getWord().indexOf(pattern) != -1)
				iter.remove();
		}
		return words;
	}

}
