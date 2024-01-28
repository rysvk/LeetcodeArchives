class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res(numRows);
        for(int i=0;i<numRows;i++){
            res[i]=vector<int>(i+1,1);
            for(int j=1;j<i;j++)
                res[i][j]=res[i-1][j]+res[i-1][j-1];
        }
        return res;
    }
};