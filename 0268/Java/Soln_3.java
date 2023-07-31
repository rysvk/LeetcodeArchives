class Solution {
    public int missingNumber(int[] nums) {
        /*
        0       1       2       3 ... n-1       n
        A[0]    A[1]    A[2]          A[n-1]          (0 to n but 1 number missing)


        XOR (0,1,2,3,....n, A[0],A[1]...A[N-1],missing number) = 0
        as X ^ X = 0  and X ^ 0 = X  and all numbers appear once from 0 to n.

        hence xor with missing number both sides
        XOR (0,1,2,3,....n, A[0],A[1]...A[N-1],missing number, missing number) = XOR(0, missing  number)
        i.e.
        XOR (0,1,2,3,....n, A[0],A[1]...A[N-1]) = missing  number

        missing number = XOR (0 ^ A[0], 1 ^ A[1], .... , n-1 ^ A[n-1], n)  
        */
        int result = nums.length;
        for(int i=0;i<nums.length;i++)
            result ^= i ^ nums[i]; 
        return result;
    }
}