class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int i=digits.size()-1;
        while(i>=0 && digits[i]==9)
            digits[i--]=0;
        if(i==-1)
            digits.insert(digits.begin(),1);
        else 
            digits[i]++;
        return digits;
    }
};