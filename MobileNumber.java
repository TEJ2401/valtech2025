package cordility.assignments;

import java.util.Scanner;


	
public class MobileNumber {
		public static boolean hasRepeatedDigits(String number) {
	        for (int i = 0; i < number.length() - 1; i++) {
	            if (number.charAt(i) == number.charAt(i + 1)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    public static boolean hasConsecutiveDigits(String number) {
	        for (int i = 0; i < number.length() - 1; i++) {
	            if (Math.abs(number.charAt(i) - number.charAt(i + 1)) != 1) {
	                return false;
	            }
	        }
	        return true;
	    }


	    public static boolean isSymmetrical(String number) {
	        int len = number.length();
	        for (int i = 0; i < len / 2; i++) {
	            if (number.charAt(i) != number.charAt(len - i - 1)) {
	                return false;
	            }
	        }
	        return true;
	    }


	    public static boolean hasRepeatingBlocks(String number) {
	        for (int i = 1; i <= number.length() / 2; i++) {
	            String block = number.substring(0, i);
	            String repeatedBlock = block.repeat(number.length() / i);
	            if (repeatedBlock.equals(number)) {
	                return true;
	            }
	        }
	        return false;
	    }


	    public static boolean hasFrequentDigits(String number) {
	        int[] digitCount = new int[10];
	        for (char digit : number.toCharArray()) {
	            digitCount[digit - '0']++;
	        }
	        for (int count : digitCount) {
	            if (count >= 5) {
	                return true;
	            }
	        }
	        return false;
	    }


	    public static int calculateRating(String number) {
	        int rating = 0;


	        if (hasRepeatedDigits(number)) {
	            rating += 10;
	        }


	        if (hasConsecutiveDigits(number)) {
	            rating += 8;
	        }


	        if (isSymmetrical(number)) {
	            rating += 7;
	        }

	        if (hasRepeatingBlocks(number)) {
	            rating += 6;
	        }

	        if (hasFrequentDigits(number)) {
	            rating += 5;
	        }


	        if (rating == 0) {
	            rating += 3; 
	        }

	        return rating;
	    }


	    public static String getStrengthDescription(int rating) {
	        if (rating >= 8) {
	            return "Very Strong: This is an easy-to-remember number with clear patterns.";
	        } else if (rating >= 5) {
	            return "Moderate: This number is fairly easy to remember with some recognizable patterns.";
	        } else {
	            return "Weak: This number is hard to remember with no clear patterns.";
	        }
	    }

	    public static void main(String[] args) {

	        String[] numbers = {
	            "1234567890", 
	            "1111111111", 
	            "1221221221",  
	            "9876543210",
	            "5555555555", 
	            "9871205432",
	            "1234321", 
	            "1122334455"  
	        };

	        for (String mobileNumber : numbers) {
	            int rating = calculateRating(mobileNumber);
	            System.out.println("For the mobile number: " + mobileNumber);
	            System.out.println("Rating: " + rating);
	            System.out.println("Strength: " + getStrengthDescription(rating));
	            System.out.println("-----------------------------------");
	        }
	    }
	}
