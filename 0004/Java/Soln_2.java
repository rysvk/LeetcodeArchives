class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int s1 = nums1.length;
        int s2 = nums2.length;

        // We want to rearrange nums1 and nums2 such that len(nums1) <= len(nums2)
        if(s1 > s2)
            return findMedianSortedArrays(nums2,nums1);
        
        final int INT_MIN = Integer.MIN_VALUE;
        final int INT_MAX = Integer.MAX_VALUE;

        /*
        Let us consider the two sorted arrays and their combined sorted array. 
        nums1                              nums2
        [                  ]               [                       ]
         0 1 2 3 4 ..  n1-1                 0 1 2 3 4 ....... n2-1

        union
        [                                                   ]
         0 1 2 3 4 ................................ n1+n2-1

        Let us split the combined array into 2 halfs such that 
        length of each sub half = len(combined)/2
        And in cases of odd length the left sub half(lower sub half)
        contains one element extra.

        Example: -
        Combined :  1 2 3 4 5 6
        Splitted : 1 2 3 | 4 5 6 

        Combined :  1 2 3 4 5 6 7
        Splitted : 1 2 3 4 | 5 6 7

        Since the combined array is also sorted, what assumptions
        can we have about the contributions made by nums1 and nums2 
        in the left sub half of the combined array   

        Extreme cases :- 
        1. All elements in nums1 are less than all elements in nums2.
        nums1 contributes all elements to the left sub half of combined sorted array.
        nums1 : 1 2 3
        nums2 : 5 6 7 8 9

        Combined : 1 2 3 5 | 6 7 8 9

        2. nums1 has no elements in the combined sorted array.
        nums1 : 100 200 300
        nums2 : 1 2 3 4 5

        Combined: 1 2 3 4 | 5 100 200 300

        Conditions for Binary search
        Lets assume nums1, nums2 contribute p1 and p2 elements to the left sub half of the combined array.

                 0 1 2 3 ... p1-1    p1 ....   n1-1
        nums1 : [                                  ]   

                 0 1 2 3 ... p2-1    p2 ....   n2-1
        nums2 : [                                  ]  


        combined : [ arrangement of nums1[0..p1-1] and nums2[0..p2-1] | arrangement of nums1[p1 .. n1-1] and nums2[p2..n2-1] ]  

        Since this is effective partition which ensures the combined array is sorted, any change in the contributions
        by nums1 and nums2 would mean the resulting array is not the sorted one.


        Conversely if this is a supposed partition,
                 0 1 2 3 ... p1-1    p1 ....   n1-1
        nums1 : [                                  ]   

                 0 1 2 3 ... p2-1    p2 ....   n2-1
        nums2 : [                                  ]

        then the resulting combined array 

        combined : [ arrangement of nums1[0..p1-1] and nums2[0..p2-1] | arrangement of nums1[p1 .. n1-1] and nums2[p2..n2-1] ]  
         
        will be sorted only if nums1[p1-1] <= nums2[p2] and nums2[p2-1] <= nums1[p1]
        
        If this condition is not met we have two cases :-
        nums1[p1-1] > nums2[p2] -- Contributions from nums1 to the leftsub half of combined needs to reduce [discard p1..n1]
        nums2[p2-1] > nums1[p1] -- Contributions from nums1 to the leftsub half of combined needs to increase [discard 0..p1]

        So we need to perform Binary search on the Count of contributions made by smaller array
        to the left half of the combined sorted array.

        */
      
        /* Bounds are minimum and maximum number of elements contributed 
           by nums1 in the (hypothetical) combined sorted array of nums1 and nums2.
        */
        int low = 0;
        int high = s1;

        int p1 = -1;
        int p2 = -1;
        int maxLower1 = -1;
        int minHigher1 = -1;

        int maxLower2 = -1;
        int minHigher2 = -1;

    
        // Answer is guranteed.
        while(low < high){
            p1 = low +(high - low)/2; 
            // P1 = current number of elements contributed by nums1 towards left sub half of combined array

            p2 = (s1 + s2 + 1) / 2 - p1;
            /* 
            Left sub half has 1 more element if combined array is odd i.e. s1 + s2 = odd
            Hence total numbers in left sub half = ( s1 + s2 + 1 ) / 2.
            Extra 1 is for s1 + s2 == odd
            So contribution made by nums2 in left sub half = total numbers in left sub half - #contribution by nums1
            */

            maxLower1 = (p1 == 0) ? INT_MIN : nums1[p1-1];
            minHigher1 = (p1 == s1) ? INT_MAX : nums1[p1];

            maxLower2 = (p2 == 0) ? INT_MIN : nums2[p2-1];
            minHigher2 = (p2 == s2) ? INT_MAX : nums2[p2];

            /*
                     0 1 2 3 ...   p1-1             p1   ....    n1-1
            nums1 : [           maxLower1       minHigher1            ]   

                     0 1 2 3 ... p2-1           p2 ....   n2-1
            nums2 : [         maxLower2      minHigher2       ]  

            combined : [ arrangement of nums1[0..p1-1] and nums2[0..p2-1] | arrangement of nums1[p1 .. n1-1] and nums2[p2..n2-1] ]  

            */

        
            if(maxLower1 >= minHigher2 || maxLower2 < minHigher1){
                // We need less contributions from nums1 on the left sub half of combined and more from nums2 for the same.
                high = p1;
            } else {
                // We need more contributions from nums1 on the left sub half of combined and more from nums2 for the same.
                low = p1 + 1;
            }
        }
        // low is number of elements contributed by nums1 to left sub half of combined arry in order for combined array to be sorted.
        p1 = low;
        p2 = (s1 + s2 + 1) / 2 - p1;
    
        // Recalculate max and min
        maxLower1 = (p1 == 0) ? INT_MIN : nums1[p1-1];
        minHigher1 = (p1 == s1) ? INT_MAX : nums1[p1];

        maxLower2 = (p2 == 0) ? INT_MIN : nums2[p2-1];
        minHigher2 = (p2 == s2) ? INT_MAX : nums2[p2];

        if((s1 + s2)%2 == 0){
            return 0.5 * (Math.max(maxLower1,maxLower2)+ Math.min(minHigher1,minHigher2));
        } else {
            return Math.max(maxLower1,maxLower2);
        }
    }
}

