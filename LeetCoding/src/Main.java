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
}