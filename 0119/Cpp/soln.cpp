class Solution {
public:
    vector<int> getRow(int rowIndex) {
        // TC : O (n2)
        // SC : O (1)
        //
        // Since the Pascal's triangle is 0-indexed, we can draw the following conclusions
        //
        //  Row Index             Number of elements in Row
        //      0                           1
        //      1                           2     
        //      2                           3
        //      n                         n + 1
        //
        // Each row starts and ends with 1. 
        // Each row can be formed from the Previous row.
        //
        //  1
        //  1 1
        //  1 2 1
        //  1 3 3 1
        //
        // Each element at index j in row i, other than the starting and ending 1 are sum of the :-
        // 1. The element at same index j in previous row (i-1) : arr[i-1][j]
        // 2. The element at left to the above element : arr[i-1][j-1]
        //
        // Natural instinct in to define a 2D array but we can optimize this.
        // We need an array(res) of size rowIndex + 1 obviously. Lets initialize every value to 1.
        // For each inner value, index j in rows starting from row = 2, we can calculate :-
        // res[j] = res[j] + res [j-1]
        //
        // But going Left -> Right in each row would mean we end up using the current value twice 
        // for the next index. Eg. row Index = 3 => res = [1 3 3 1]
        //
        // 1 1 1 1    row = 0 [No need to process]
        // 1 1 1 1    row = 1 [No need to process]
        //
        //               
        // 1 1 1 1   =>    1 2 1 1  
        // 1 2 1 1    row = 2 [No observable error]
        //

        // 1 2 1 1   =>    1 3 1 1    =>    1 3 4 1 
        // 1 3 4 1    row = 3 [1 got added multiple time]
        // 
        // Hence for each row, we travel from the right end of the array to the front
        //
        // 1 1 1 1    row = 0 [No need to process]
        // 1 1 1 1    row = 1 [No need to process]
        //
        // 1 1 1 1   =>    1 2 1 1    
        // 1 2 1 1    row = 2 
        //
        //
        // 1 2 1 1   =>    1 2 3 1    =>    1 3 3 1 
        // 1 3 3 1    row = 3 
        // 
        // For each row start index j from right end to front [i-1 to 1]


        vector<int> res( rowIndex + 1, 1);
        for(int i = 2; i <= rowIndex; i++)
            for(int j = i - 1 ; j > 0; j--)
                res[j] += res[j - 1];
        return res;
    }
};