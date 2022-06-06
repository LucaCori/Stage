package progetto;

import java.util.ArrayList;
import java.util.List;

public class Words {
	
	static String[] elements = {
			"hello",
			"heritage",
			"happiness",
			"goodbye",
			"cruel",
			"car",
			"war",
			"will",
			"world",
			"wall"
	};
	
	public static List<String> getWords() {
		List<String> words = new ArrayList<>();
		for(int i = 0; i < elements.length; i++) {
			words.add(elements[i]);
		}
        return words;
	}
	
	public static String[] getWordsObjects() {
		String[] words = new String[elements.length];
		for(int i = 0; i < elements.length; i++) {
			words[i] = elements[i];
		}
		return words;
	}
	
}