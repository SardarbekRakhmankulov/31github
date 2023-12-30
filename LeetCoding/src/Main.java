import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public boolean isPalindrome(int x) {
        if(x<0)                                   // if input is negative then it will not be palindrome , since -101 become 101-
            return false;
        int reversed = 0;
        int copyOfx = x;
        while(copyOfx!=0){
            reversed = reversed*10+copyOfx%10;   // constructing reverse for postive integer
            copyOfx=copyOfx/10;
        }                                        // reverse integer will be constructed

        return x==reversed;                      // compare reverse integer value with original value and return ans
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;

        for (int num : nums)
            if (num != val)
                nums[i++] = num;

        return i;
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; --i)
            if ((num.charAt(i) - '0') % 2 == 1)
                return num.substring(0, i + 1);
        return "";
    }

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ')
            --i;
        final int lastIndex = i;
        while (i >= 0 && s.charAt(i) != ' ')
            --i;

        return lastIndex - i;
    }

    double myPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow(x, -n);
        if (n % 2 == 1)
            return x * myPow(x, n - 1);
        return myPow(x * x, n / 2);
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int[] count = new int[128];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            ++count[s.charAt(r)];
            while (count[s.charAt(r)] > 1)
                --count[s.charAt(l++)];
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public int reverse(int x) {
        long ans = 0;

        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) ? 0 : (int) ans;
    }

    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            final int minHeight = Math.min(height[l], height[r]);
            ans = Math.max(ans, minHeight * (r - l));
            if (height[l] < height[r])
                ++l;
            else
                --r;
        }

        return ans;
    }

    public int divide(long dividend, long divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        final int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
        long ans = 0;
        long dvd = Math.abs(dividend);
        long dvs = Math.abs(divisor);

        while (dvd >= dvs) {
            long k = 1;
            while (k * 2 * dvs <= dvd)
                k *= 2;
            dvd -= k * dvs;
            ans += k;
        }

        return sign * (int) ans;
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");

        while (--n > 0) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < sb.length(); ++i) {
                int count = 1;
                while (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) {
                    ++count;
                    ++i;
                }
                next.append(count).append(sb.charAt(i));
            }
            sb = next;
        }

        return sb.toString();
    }

    public void rotate(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < j; ++i, --j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

        for (int i = 0; i < matrix.length; ++i)
            for (int j = i + 1; j < matrix.length; ++j) {
                final int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public int mySqrt(long x) {
        long l = 1;
        long r = x + 1;

        while (l < r) {
            final long m = (l + r) / 2;
            if (m > x / m)
                r = m;
            else
                l = m + 1;
        }

        // l := the minimum number s.t. l * l > x
        return (int) l - 1;
    }

    public int strStr(String haystack, String needle) {
        final int m = haystack.length();
        final int n = needle.length();

        for (int i = 0; i < m - n + 1; ++i)
            if (haystack.substring(i, i + n).equals(needle))
                return i;

        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }

    public int climbStairs(int n) {
        int prev1 = 1; // dp[i - 1]
        int prev2 = 1; // dp[i - 2]

        for (int i = 2; i <= n; ++i) {
            final int dp = prev1 + prev2;
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }

    public int missingNumber(int[] nums) {
        int count[] = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for(int i=0;i<=nums.length;i++){
            if(count[i]==0) return i;
        }
        return -1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;     // nums1's index (the actual nums)
        int j = n - 1;     // nums2's index
        int k = m + n - 1; // nums1's index (the next filled position)

        while (j >= 0)
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); ++i)
            for (int j = 1; j < strs.length; ++j)
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);

        return strs[0];
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (final char c : s.toCharArray())
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;

        return stack.isEmpty();
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        for (int i = 0; i < n; ++i)
            for (int j = ans.size() - 1; j >= 0; --j)
                ans.add(ans.get(j) | 1 << i);

        return ans;
    }

    public void sortColors(int[] nums) {
        int zero = -1;
        int one = -1;
        int two = -1;

        for (final int num : nums)
            if (num == 0) {
                nums[++two] = 2;
                nums[++one] = 1;
                nums[++zero] = 0;
            } else if (num == 1) {
                nums[++two] = 2;
                nums[++one] = 1;
            } else {
                nums[++two] = 2;
            }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>();

        for (final String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(keyToAnagrams.values());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();

        final int m = matrix.length;
        final int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int r1 = 0;
        int c1 = 0;
        int r2 = m - 1;
        int c2 = n - 1;

        // Repeatedly add matrix[r1..r2][c1..c2] to `ans`.
        while (ans.size() < m * n) {
            for (int j = c1; j <= c2 && ans.size() < m * n; ++j)
                ans.add(matrix[r1][j]);
            for (int i = r1 + 1; i <= r2 - 1 && ans.size() < m * n; ++i)
                ans.add(matrix[i][c2]);
            for (int j = c2; j >= c1 && ans.size() < m * n; --j)
                ans.add(matrix[r2][j]);
            for (int i = r2 - 1; i >= r1 + 1 && ans.size() < m * n; --i)
                ans.add(matrix[i][c1]);
            ++r1;
            ++c1;
            --r2;
            --c2;
        }

        return ans;
    }
}