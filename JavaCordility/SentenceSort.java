package cordility.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SentenceSort {
	 public static int countVowels(String sentence) {
	        int vowelCount = 0;
	        sentence = sentence.toLowerCase(); // Convert to lowercase for simplicity
	        for (int i = 0; i < sentence.length(); i++) {
	            char ch = sentence.charAt(i);
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                vowelCount++;
	            }
	        }
	        return vowelCount;
	    }

	    public static void main(String[] args) {

	        List<String> sentences = Arrays.asList(
	            "Hello World",
	            "This is a test sentence.",
	            "Java programming is fun!",
	            "How many vowels are in this sentence?",
	            "A quick brown fox jumps over the lazy dog."
	        );


	        Collections.sort(sentences, (a, b) -> countVowels(a) - countVowels(b));


	        System.out.println("Sentences sorted by vowel count:");
	        for (String sentence : sentences) {
	            System.out.println(sentence + " (Vowels: " + countVowels(sentence) + ")");
	        }
	    }
}
