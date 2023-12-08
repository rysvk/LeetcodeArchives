class Solution {
private:
    /**
    Matrix Exponentiation Solves thisp roblem in the most optimal way.
    TC O(lg n)
    SC O(1)

    Fact to remember :-
    For Fibonacci 1 1 2 3 5 8 ....
    Lets say X = [1 1] 
                 [1 0]

    X^N = [Fn+1   Fn]
          [Fn   Fn-1]

    Here Number of ways to reach step 0 = F1
         Number of ways to reach step 1 = F2
         Number of ways to reach step 2 = F3

         Number of ways to reach step N = Fn+1

    **/
    void multiply(vector<vector<long>>& m1,vector<vector<long>>& m2){
        /*
        m1          m2          res
        00 01       00 01       00 01 
        10 11       10 11       10 11
        */
        long res00 = m1[0][0]*m2[0][0] + m1[0][1]*m2[1][0];
        long res01 = m1[0][0]*m2[0][1] + m1[0][1]*m2[1][1];
        long res10 = m1[1][0]*m2[0][0] + m1[1][1]*m2[1][0];
        long res11 = m1[1][0]*m2[0][1] + m1[1][1]*m2[1][1];
        m1[0][0]=res00;
        m1[0][1]=res01;
        m1[1][0]=res10;
        m1[1][1]=res11;
    }
public:
    int climbStairs(int n) {
        vector<vector<long>> m1 ={{1,0}, {0,1}};
        vector<vector<long>> x = {{1,1}, {1,0}};
        while(n){
            if(n&1)
                multiply(m1,x);
            n>>=1;
            multiply(x,x);
        }
        return (int)m1[0][0];
    }
};