import java.util.*;
public class SubarraysDivByK {
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // important

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int rem = prefixSum % k;

            // handle negative remainder
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        System.out.println(count);
    }
}
