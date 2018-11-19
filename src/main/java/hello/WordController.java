package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.reponseBean.PalindromeBean;

@RestController
public class WordController {
    // TODO Implement the /words/{word} endpoint
	
	@RequestMapping(value = "/words/{word}", produces = "application/json")
	private PalindromeBean checkWord(@PathVariable("word")  String word) {		
		PalindromeBean bean =  new PalindromeBean();
		bean.setPalindrome(checkPalindrome(word));
		bean.setAnagramOfPalindrome(checkAnagram(word));
		bean.setWord(word);
		return bean;
	}
	
	/**
	 * 
	 * Below method is to check whether given string is Anagram of palindrome 
	 * or not .
	 * @param word - input String
	 * 
	 * **/
	public static boolean checkAnagram(String word) {
		int oddCount = 0;
		word = word.toLowerCase();
		int[] count = new int[256];
 		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			count[ch]++;
		}
 		
 		for (int currentCnt : count) {
			if (oddCount > 1) {
				return false;
			}
			if (currentCnt % 2 == 1) {
				oddCount++;
			}
		}
		return true;
	}
 	
	/**
	 * 
	 * Below method is to check whether given string is palindrome 
	 * or not .
	 * @param word - input String
	 * 
	 * **/
	public static boolean checkPalindrome(String word) {
		String revWord = "";
		for (int i = word.length() - 1; i >= 0; i--)
			revWord = revWord + word.charAt(i);
	
		if (word.toLowerCase().equals(revWord.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
}

