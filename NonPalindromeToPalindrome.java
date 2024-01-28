import java.util.Scanner;

public class NonPalindromeToPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sentence from the user
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Split the sentence into words
        String[] words = sentence.split("\\s+");

        // Process each word
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!isPalindrome(word)) {
                // If the word is not a palindrome, convert it to a palindrome
                String palindrome = word + new StringBuilder(word).reverse().toString();
                result.append(palindrome).append(" ");
            } else {
                // If the word is already a palindrome, keep it as it is
                result.append(word).append(" ");
            }
        }

        // Output the result
        System.out.println("Result: " + result.toString().trim());

        scanner.close();
    }

    // Method to check if a word is a palindrome
    private static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}