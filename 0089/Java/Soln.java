class Solution {
    public List<Integer> grayCode(int n) {
        // ArrayList performs better than LinkedList
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0;i < n; i++){
            for(int j = res.size() - 1; j >= 0; j--)
                res.add(res.get(j) | (1 << i));
        }
        return res;
    }
}