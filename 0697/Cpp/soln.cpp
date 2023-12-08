class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        // Since the values in the array are not within a range and we need to find the once with highest frequency,
        // we definitely need to store the frequencies of elements, naturally Map is the choice.
        //
        // Now to calculate the smallest subarray which has the same degree as nums, we definitely need to include the 
        // element with the maximum frequency in that subarray(otherwise the degree of the subarray might reduce).
        //
        // So our goal is to find the element which occurs most frequently over the least span.
        // For calcualting the span we can keep another map storing the first occurence of every element.
        // Wehenever the count of the current element is greater than the maximum till this far, we will update the 
        // result with the current span. If the current frequency is same as maximum till now, we will try to 
        // minimize the span if possible.

        unordered_map<int,int> firstOccurence;
        unordered_map<int,int> count;
        int maxCnt = 0;
        int res = nums.size();
        for(int i = 0; i < nums.size(); i++){
            count[nums[i]]++;
            if(count[nums[i]] == 1)
                firstOccurence[nums[i]] = i;
            
            if(count[nums[i]] > maxCnt){
                maxCnt = count[nums[i]];
                res = i - firstOccurence[nums[i]] + 1;
            } else if(count[nums[i]] == maxCnt){
                res = min(res, i - firstOccurence[nums[i]] + 1);
            }
        }
        return res;
    }
};