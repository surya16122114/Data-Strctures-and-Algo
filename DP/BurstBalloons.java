package DP;

class BurstBalloons{
    class Solution {
        int[] nums;
        int[][] dp;

        public int maxCoins(int[] arr) {
            int n = arr.length;

            nums = new int[n + 2];
            nums[0] = 1;
            nums[n + 1] = 1;

            for (int i = 0; i < n; i++) {
                nums[i + 1] = arr[i];
            }

            dp = new int[n + 2][n + 2];

            return dfs(1, n);
        }

        private int dfs(int l, int r) {
            if (l > r) {
                return 0;
            }

            if (dp[l][r] != 0) {
                return dp[l][r];
            }

            int max = 0;

            for (int i = l; i <= r; i++) {
                int coins = nums[i] * nums[l - 1] * nums[r + 1]
                        + dfs(l, i - 1)
                        + dfs(i + 1, r);

                max = Math.max(max, coins);
            }

            dp[l][r] = max;
            return max;
        }
    }
}