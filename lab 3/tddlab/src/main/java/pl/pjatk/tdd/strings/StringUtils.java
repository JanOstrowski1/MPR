package pl.pjatk.tdd.strings;

public class StringUtils {
    public static int sumOfNumbersInAString(String string){
        int sum=0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            sum+= Character.getNumericValue(c);
        }
        return sum;
    }

    public static boolean palindrome(String s){
        char [] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i]!=c[c.length-i-1]){
                return false;
            }
        }
        return true;
    }

}
