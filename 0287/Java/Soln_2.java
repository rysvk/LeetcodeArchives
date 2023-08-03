class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        
        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
/*
Let us form a list where 
index is the current node and 
nums[index] is the next node.

Since all elements are within [1..n], element at index 0 is the head of the list

nums = [1,3,4,2,2]
index=  0,1,2,3,4

(1) -> (3) -> (2) -> (4)
               ^      |
               |______|


nums = [2,6,4,1,3,1,5]
index=  0,1,2,3,4,5,6

(2) -> (4) -> (3) -> (1) -> (6) -> (5)
                      ^             |
                      |_____________|
                      

nums = [4,1,4,4,4]
index=  0,1,2,3,4

(4) __
 ^    |
 |____|


nums = [1,4,4,4,4]
index=  0,1,2,3,4

(1) -> (4) __
        ^    |
        |____|

*/