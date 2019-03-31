/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {

	public static void main(String args[]) {
		String s = "bb";	
		System.out.println(longestPalindrome(s));
	}
	
	// Not the best solution but one of the Solutions
	public static String longestPalindrome(String s) {
		if(s.length() == 1) {
			return s;
		}
		String temp = "";
        for(int i = 0;i < s.length();i++){
            for(int j = i+1 ; j<= s.length();j++){
                String s_p = s.substring(i, j);
                if(isPalindrome(s_p) && temp.length() < s_p.length()){
                    temp = s_p;
                }
            }
        }
        return temp;
    }
	public static boolean isPalindrome(String s){
        int n = s.length()-1;
        for(int i=0;i < s.length()/2 ;i++){
            if(s.charAt(i) != s.charAt(n-i)){
                return false;
            }
        }
        return true;
    }
}
