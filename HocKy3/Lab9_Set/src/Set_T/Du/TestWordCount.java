package Set_T.Du;

import java.io.FileNotFoundException;
import java.util.List;

public class TestWordCount {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "data/fit.txt";
		List<String> words = LoadUtils.loadUtils(fileName);

		System.out.println("get word counts: " + MyWordCount.getWordCounts(words));
		System.out.println("get unique word: " + MyWordCount.getUniqueWords(words));
		System.out.println("get distinct word: " + MyWordCount.getDistinctWords(words));
		System.out.println(MyWordCount.exportWordCounts(words));
		System.out.println(MyWordCount.exportWordCountsOrderByOccurence(words));
		System.out.println(MyWordCount.filterWords(MyWordCount.getWordCounts(words), "Nong"));

	}
}
