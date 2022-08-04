import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,60,37,9,5};
        String result = largestNumber(numbers);
        System.out.println("The largest number is " + result);
    }

    public static String largestNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = numbers[i]+"";
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });

        if (strArr[strArr.length-1].charAt(0) == '0')
            return "0";

        String res = "";
        for (int i = 0; i < strArr.length; i++) {
            res = strArr[i] + res;
        }
        return res;
    }
}
