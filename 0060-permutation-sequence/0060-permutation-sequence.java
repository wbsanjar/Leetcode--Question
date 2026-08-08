class Solution {
    public String getPermutation(int n, int k) {

        // 1. Numbers ko list me store karo
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // 2. (n-1)! calculate karo
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        // 3. k ko 0-based bana do
        k--;

        StringBuilder ans = new StringBuilder();

        // 4. Har position ka number find karo
        for (int i = n; i > 0; i--) {

            // Kaunsa block select hoga?
            int index = k / fact;

            // Number answer me add karo
            ans.append(nums.get(index));

            // Selected number remove karo
            nums.remove(index);

            // Next position ke liye k update
            k = k % fact;

            // Factorial update
            if (i > 1) {
                fact /= (i - 1);
            }
        }

        return ans.toString();
    }
}