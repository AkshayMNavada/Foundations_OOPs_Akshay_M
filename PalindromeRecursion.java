public class PalindromeRecursion {
    public static void main(String[] args) {
        String str1 = "AKA";
        String str2 = "JAVA";
        String str3 = "LEVEL";

        System.out.println("Is "+str1+ " a palindrome ? : " + isPalindrome(str1,0,str1.length()-1));
        System.out.println("Is "+str2+ " a palindrome ? : " + isPalindrome(str2,0,str2.length()-1));
        System.out.println("Is "+str3+ " a palindrome ? : " + isPalindrome(str3,0,str3.length()-1));
    }

    public static boolean isPalindrome(String str, int start, int end){
        if (start == end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        if (start < end+1)
            return isPalindrome(str, start+1, end-1);
        return true;
    }
}
