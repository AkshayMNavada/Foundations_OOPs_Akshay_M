import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] resultArray = twoSum(nums, target);
        for (int result: resultArray){
            System.out.print(result + " ");
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[1] = i;
                result[0] = map.get(diff);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
