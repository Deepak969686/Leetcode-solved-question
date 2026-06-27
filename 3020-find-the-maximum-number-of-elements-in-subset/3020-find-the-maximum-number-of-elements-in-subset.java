class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> freq = new HashMap<>();

        // Count frequency
        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Special case for number 1
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);

            if (cnt % 2 == 0)
                ans = Math.max(ans, cnt - 1);
            else
                ans = Math.max(ans, cnt);
        }

        // Try every possible starting value
        for (long start : freq.keySet()) {

            if (start == 1)
                continue;

            long curr = start;
            int len = 0;

            while (true) {

                int cnt = freq.getOrDefault(curr, 0);

                if (cnt >= 2) {

                    // take one on left and one on right
                    len += 2;

                    // prevent overflow
                    if (curr > 1000000000L)
                        break;

                    curr = curr * curr;

                } else if (cnt == 1) {

                    // middle element
                    len++;

                    break;

                } else {

                    // remove extra pair because no center exists
                    len -= 1;

                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}