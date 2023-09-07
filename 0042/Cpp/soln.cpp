class Solution {
public:
    int trap(vector<int>& height) {
        // TC : O(n)
        // SC : O(1)
        // 
        // Since this is an elevation map, each height[i] represent a block of height = height[i].
        //
        // Let us try to see in general how much water can we calculate above each and every block.
        //                                          _
        //                     _                   | |
        //           leftmax  | |                  | | rightax 
        //                    | |                  | |              
        //                    | |         _        | |
        //  __________________| |________| |_______| |__________________
        //                                i     
        // For any block of index i, let us imagine the maximum height on left and right are :-
        // leftMax and rightMax respectively.
        // Then the water if trapped in between the leftMax and rightMax block would be have height 
        // min(leftMax, rightMax)
        //                                          _     
        //                     _ __ __ __ __ __ ___| |
        //           leftmax  | |      _       _   | | rightax 
        //                    | |   _        _     | |              
        //                    | |_    _   _    _   | |
        //  __________________| |________| |_______| |__________________
        //                                i
        // Consequently the column of water above block 'i' = min (leftMax, rightMax) - i
        //
        // Therefore for each i we should keep track of leftMax, rightMax and calculate the contribution by each block.
        //
        // But where should we start ? 
        // We cannot iterate from 0 to n-1 as we would need another pass/array to store the maximum and minimum.
        // We should follow a 2 pointer apporach low, high
        // Low starts at 0 and High at size(height)-1
        // Each time we have to calculate contribution of the block with the lower height.
        // What should be initial values of leftMax and rightMax :-
        // INT_MIN [as we have not encountered any blocks beyond the first and last one]


        int low = 0;
        int high = height.size()-1;
        int rain = 0;
        int leftMax = INT_MIN;
        int rightMax = INT_MIN;
        while(low <= high){
            if(height[low] < height[high]){   // low block has lesser height, calculate its contribution.
                // update leftMax before calculating contribution
                leftMax = max(leftMax, height[low]);
                rain += leftMax - height[low++]; // to need to consider rightMax as height[low] < height[high]
            } else {   // high block has lesser height, calculate its contribution.
                // update leftMax before calculating contribution
                rightMax = max(rightMax, height[high]);
                rain += rightMax - height[high--]; // to need to consider leftMax as height[high] < height[low]
            }
        }
        return rain;  
    }
};