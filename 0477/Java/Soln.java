class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int j = 0;j < 32; j++){
            int num1 = 0;
            for(int i = 0;i < nums.length; i++){
                if((nums[i] & 1) != 0)
                    num1 ++;
                nums[i] >>= 1;
            }
            res += (n - num1) * num1;
        }
        return res;
    }
}

