import java.util.*;
public class GoodSubarray {
    public static long countGoodSubarrays(int[] a, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        long count = 0;
        int left = 0;
        for (int right = 0; right < a.length; right++) {
            freq.merge(a[right], 1, Integer::sum);
            // Shrink window if element appears more than k times
            while (freq.get(a[right]) > k) {
                freq.merge(a[left], -1, Integer::sum);
                if (freq.get(a[left]) == 0) freq.remove(a[left]);
                left++;
            }
            count += right - left + 1; // All subarrays ending at 'right'
        }
        return count;
    }
}