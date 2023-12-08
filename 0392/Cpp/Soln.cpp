class Solution {
public:
    bool isSubsequence(string s, string t) {
        /**
        DP approach : This is not the best approach for this problem however lets see how we can apply DP here.

        Let dp[i][j] => indicate(true/false) whether s[0..i-1] is a subsequence of t[0..j-1]
        that is whether prefix of s of length i is a subsequence of prefix of t of length j

        Naturally dp[0][?] => true as s is empty string.
        Also dp[i][0]      => false when i>0, for all preefix string of s which isnt empty.

        Also now for dp[i][j] we need to check if s[i-1] == t[j-1]

        Yes => dp[i][j] = dp[i-1][j-1] .. last characters are same 
                          check subproblems where the last character is not present in both

        Np  => dp[i][j] = dp[i][j-1] .. last characters are not same
                          check subproblem excluding the last character of t.
        **/

        vector<vector<bool>> dp(s.length()+1, vector<bool>(t.length() + 1));
        for(int i = 0;i <= s.length(); i++){
            for(int j = 0;j <= t.length(); j++){
                if(!i || !j)
                    dp[i][j]=!i;
                else
                    dp[i][j]= s[i-1]==t[j-1]  ? dp[i-1][j-1] : dp[i][j-1];
            }
        }
        return dp[s.length()][t.length()];
    }
};